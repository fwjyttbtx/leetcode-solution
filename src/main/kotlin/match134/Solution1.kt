package match134

object Solution1 {

    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        val sorts = listOf(a, b, c).sorted()
        val abRange = sorts[1] - sorts[0] - 1
        val bcRange = sorts[2] - sorts[1] - 1
        var maxSteps = 0
        var minStep = when {
            abRange > 0 && bcRange > 0 -> Math.min(abRange, bcRange)
            abRange == 0 -> bcRange
            else -> abRange
        }

        var acMin = 0
        if (abRange > 0) {
            acMin++
            maxSteps += abRange
        }
        if (bcRange > 0) {
            acMin++
            maxSteps += bcRange
        }
        if (acMin in 1 until minStep) {
            minStep = acMin
        }
        return intArrayOf(minStep, maxSteps)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(numMovesStones(2, 4, 1).joinToString())
        println(numMovesStones(3, 5, 1).joinToString())
        println(numMovesStones(1, 2, 5).joinToString())
        println(numMovesStones(3, 2, 4).joinToString())
    }

}