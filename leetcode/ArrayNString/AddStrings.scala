// https://leetcode.com/problems/add-strings
object AddStrings {
  def addStrings(num1: String, num2: String): String = {
    (BigInt(num1) + BigInt(num2)).toString
  }
}