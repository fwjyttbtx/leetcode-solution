object Solution4 {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val leftSize = nums1.size
        val rightSize = nums2.size
        val total = leftSize + rightSize
        val half = total / 2
        if (nums1.isEmpty()) return if (total % 2 == 0) (nums2[half - 1] + nums2[half]) / 2.0 else nums2[half].toDouble()
        if (nums2.isEmpty()) return if (total % 2 == 0) (nums1[half - 1] + nums1[half]) / 2.0 else nums1[half].toDouble()
        val leftPart = mutableListOf<Int>()
        var nums1Cursor = 0
        var nums2Cursor = 0
        while (leftPart.size <= half) {
            // 检查下标 如果数组下标超过 则需要重置到最大下标
            val curLeft = if (nums1Cursor >= nums1.size) null else nums1[nums1Cursor]
            val curRight = if (nums2Cursor >= nums2.size) null else nums2[nums2Cursor]
            if (curLeft != null && curRight != null) {
                if (curLeft >= curRight) {
                    leftPart.add(curRight)
                    nums2Cursor++
                } else if (curLeft < curRight) {
                    leftPart.add(curLeft)
                    nums1Cursor++
                }
            } else if (curLeft != null) {
                leftPart.add(curLeft)
                nums1Cursor++
            } else if (curRight != null) {
                leftPart.add(curRight)
                nums2Cursor++
            }
            println(leftPart)
            if (leftPart.size > half) {
                return if (total % 2 == 0) {
                    (leftPart[leftPart.size - 1] + leftPart[leftPart.size - 2]) / 2.0
                } else {
                    leftPart[leftPart.size - 1].toDouble()
                }
            }
        }
        throw IllegalArgumentException("No Solution")

    }

    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size
        val odd = total % 2 == 1
        var totalIndex = 0
        var sum = 0.0
        var index1 = 0
        var index2 = 0
        var upper: Int
        var lower: Int
        lower = (total - 1) / 2
        upper = if (odd) {
            lower
        } else {
            total / 2
        }
        while (index1 < nums1.size || index2 < nums2.size) {
            var choose: Int = if (index1 >= nums1.size) {
                nums2[index2++]
            } else if (index2 >= nums2.size) {
                nums1[index1++]
            } else {
                if (nums1[index1] <= nums2[index2]) nums1[index1++] else nums2[index2++]
            }
            if (totalIndex < lower) {
                totalIndex++
                continue
            }
            if (totalIndex in lower..upper) {
                sum += choose
                totalIndex++
            }
            if (totalIndex > upper) {
                break
            }
        }
        return sum / if (odd) {
            1.0
        } else {
            2.0
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
    }

}