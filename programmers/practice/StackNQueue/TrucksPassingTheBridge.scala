import scala.collection.mutable

object TrucksPassingTheBridge {
  def solution(bridge_length: Int, weight: Int, truck_weights: Vector[Int]): Int = {
    // 요소 추가 및 제거가 자유로운 mutable collection 사용
    // 코드 간결성 및 시간 복잡도 모두 고려하여 mutable collection이 immutable collection보다 이점이 있다고 판단
    val remainingTrucks = truck_weights.toBuffer
    val bridge: mutable.Queue[Int] = mutable.Queue.fill(bridge_length)(0)
    var secs: Int = 0

    while (remainingTrucks.nonEmpty) {
      // 변수 선언문이 스코프 상단에 위치해야 하나,
      // 그 경우 아래서 filter 함수를 추가로 호출하게 되므로 조금이라도 속도를 개선하기 위해 dequeue()를 상단에 호출
      bridge.dequeue()

      val elem =
        if (weight - bridge.sum >= remainingTrucks.head) remainingTrucks.head
        else 0

      bridge.enqueue(elem)
      secs += 1

      if (elem > 0) remainingTrucks -= remainingTrucks.head
    }

    secs + bridge.lastIndexWhere(_ > 0) + 1
  }
}