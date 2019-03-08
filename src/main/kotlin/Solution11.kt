import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo

object Solution11 {

    fun maxArea(height: IntArray): Int {
        if (height.isEmpty()) return 0
        // 获取第一个值和最后一个值的面积大小
        var start = 0
        var last = height.size - 1
        var max = 0
        while(start < last) {
            val area = Math.min(height[start], height[last]) * (last - start)
            if (area > max) {
                max = area
            }
            if (height[start] >= height[last]) {
                last--
            } else {
                start++
            }
        }
        return max
    }

    fun maxArea2(height: IntArray): Int {
        // 穷举 遍历全部的数组内高度
        var max = 0
        for (i in 0 until height.size - 1) {
            for (j in 1 until height.size) {
                val area = Math.min(height[i], height[j]) * (j - i)
                if (max < area) max = area
            }
        }
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertThat(maxArea(intArrayOf()), equalTo(expected = 0))
        assertThat(maxArea(intArrayOf(1)), equalTo(expected = 0))
        assertThat(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)), equalTo(expected = 49))
        assertThat(maxArea(intArrayOf(1, 1, 1, 3, 1, 3)), equalTo(expected = 6))
    }

}