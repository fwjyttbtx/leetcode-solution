class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed{ i, n ->
            val solution = target - n
            if (map.containsKey(solution)) {
                return intArrayOf(map[solution]!!, i)
            }
            map[n] = i
        }
        throw IllegalArgumentException("No Solution")
    }
}