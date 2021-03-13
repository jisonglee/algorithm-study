import scala.collection.mutable

// https://leetcode.com/problems/max-area-of-island/
object MaxAreaOfIsland {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    val buffer = grid.map(_.toBuffer).toBuffer
    var max: Int = 0

    def getMaxArea(i: Int, j: Int, grid: mutable.Buffer[mutable.Buffer[Int]]): Int = {
      if (i < 0 || j < 0 || grid.length <= i || grid(i).length <= j) 0
      else {
        if (grid(i)(j) > 0) {
          grid(i).update(j, 0)
          1 + getMaxArea(i+1, j, grid) + getMaxArea(i-1, j, grid) + getMaxArea(i, j+1, grid) + getMaxArea(i, j-1, grid)
        }
        else 0
      }
    }

    for((b, i) <- buffer.zipWithIndex) {
      for(j <- b.indices) {
        val cur = getMaxArea(i, j, buffer)
        if (cur > max) {
          max = cur
        }
      }
    }

    max
  }
}