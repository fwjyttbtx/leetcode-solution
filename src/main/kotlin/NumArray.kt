class NumArray(val nums: IntArray) {

    fun sumRange(i: Int, j: Int): Int {
        return (i..j).sumBy { nums[it] }
    }

}

fun main(args: Array<String>) {
    println(NumArray(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)).sumRange(1, 2))
}