object StoneMove {
    fun numMovesStonesII(stones: IntArray): IntArray {
        // 最小的值不可以变得更小 最大的值不可以变的更大
        // 1. 找到可以连续的位置 且连续位置是不含最大值和最小值的
        // 2. 找到最大值和最小值
        // 3. 最大值和连续值的最小值的差
        // 4. 最小值和连续纸的最大值的差
        var min: Int = stones[0]
        var max: Int = stones[0]
        var serial: MutableList<Int> = mutableListOf()
        stones.forEach {
            if (it < min) min = it
            if (it > max) max = it
        }
        return intArrayOf()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(numMovesStonesII(intArrayOf(6, 5, 4, 3, 10)))
    }
}