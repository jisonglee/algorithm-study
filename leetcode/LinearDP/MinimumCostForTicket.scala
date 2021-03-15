
import scala.annotation.tailrec

// https://leetcode.com/problems/minimum-cost-for-tickets
object MinimumCostForTicket {
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    // DP를 mutable.ArrayBuffer로 바꿔도 보고
    // DP List[(Int, Int)] 에서 List[Int]로 바꿔 `lift` 함수를 사용해봤지만
    // 성능은 크게 차이 나지 않았다..
    @tailrec
    def getMinCost(days: List[Int], costs:List[Int], dp:List[(Int, Int)]): Int = {
      days match {
        case head :: tail =>
          val withOneDay = dp.findLast(_._1 <= head - 1).map(_._2).getOrElse(0) + costs.head
          val with7Days = dp.findLast(_._1 <= head - 7).map(_._2).getOrElse(0) + costs(1)
          val with30Days = dp.findLast(_._1 <= head - 30).map(_._2).getOrElse(0) + costs(2)

          val cost = Math.min(Math.min(withOneDay, with7Days), with30Days)

          getMinCost(tail, costs, dp :+ (head, cost))
        case Nil => dp.last._2
      }
    }

    getMinCost(days.toList, costs.toList, List.empty)
  }
}