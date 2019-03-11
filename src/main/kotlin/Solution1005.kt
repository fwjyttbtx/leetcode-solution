//object Solution1005 {
//
//    fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
//        var k = K
//        val otherA = A.sorted().mapIndexed { i, a ->
//            if (i < k && a == 0) {
//                k = 0
//                a
//            } else if (i < k && a > 0) {
//                k = 0
//                if (-2 * A[i - 1] > 2 * a) {
//                    -2 * a
//                } else {
//                    -2 * A[i - 1]
//                }
//            } else {
//                -a
//            }
//        }
//        return otherA.sum()
//    }
//
//    @JvmStatic
//    fun main(args: Array<String>) {
//        println(largestSumAfterKNegations(intArrayOf(2, -3, -1, 5, -4), 2))
//        println(largestSumAfterKNegations(intArrayOf(-8, 3, -5, -3, -5, -2), 6))
//    }
//
//}