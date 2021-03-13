import scala.annotation.tailrec

// https://leetcode.com/problems/min-cost-climbing-stairs
object MinCostClimbingStairs {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    @tailrec
    def getMinCost(arr: List[Int], firstDp: Int, secondDp: Int): Int = {
      arr match {
        case _ :: mid :: tail =>
          getMinCost(mid +: tail, secondDp, Math.min(firstDp, secondDp) + tail.headOption.getOrElse(0))
        case _ :: _ => Math.min(firstDp, secondDp)
        case Nil => Math.min(firstDp, secondDp)
      }
    }

    getMinCost(cost.toList, cost.headOption.getOrElse(0), cost.lift(1).getOrElse(0))
  }
}