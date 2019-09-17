object Solution14 {

    fun threeSum(nums: IntArray): List<List<Int>> {
//        if (nums.size < 3) return emptyList()
//        val ret = mutableSetOf<List<Int>>()
//        val sortedNums = nums.sorted()
//        run breakLoop@{
//            sortedNums.forEachIndexed outLoop@ { i, num1 ->
//                if (num1 > 0) return@breakLoop
//                for (j in sortedNums.size - 1 downTo 0) {
//                    val num2 = sortedNums[j]
//                    if (num2 < 0) return@outLoop
//                    val num3 = 0 - num1 - num2
//                    val k = sortedNums.indexOf(num3)
//                    if (k >= 0 && k != i && k != j) {
//                        ret.add(listOf(num1, num2, num3).sorted())
//                    }
//                }
//            }
//        }
//        return ret.toList()
        val bigger = mutableListOf<Int>()
        val litter = mutableListOf<Int>()
        nums.forEach {
            if (it > 0) bigger.add(it)
            else if (it < 0) litter.add(it)

        }
        return emptyList()
    }

    fun threeSumEx(nums: IntArray): List<List<Int>> {
        val ret = mutableSetOf<List<Int>>()
        val size = nums.size
        for (i in 0 until size) {
            val num1 = nums[i]
            if (i + 1 >= size) break
            for (j in (i + 1) until size) {
                val num2 = nums[j]
                if (j + 1 >= size) break
                for (k in (j + 1) until size) {
                    val num3 = nums[k]
                    if (num1 + num2 + num3 == 0) {
                        ret.add(listOf(num1, num2, num3).sorted())
                    }
                }
            }
        }
        return ret.toList()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        for(i in 10 - 1 downTo 0) {
            println(i)
        }
    }

}