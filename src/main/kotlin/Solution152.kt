import kotlin.math.max
import kotlin.math.min

/**
 *
 * @author wjfu@wisedu.com
 */
object Solution152 {
    /**
     * 双循环, 低效的方案
     */
    fun maxProduct2(nums: IntArray): Int {
        val size = nums.size
        if (size == 1) {
            return nums[0]
        }
        var maxRet = 0
        nums.forEachIndexed { i, s ->
            var cursorMax = s
            var cursorTotal = s
            for (j in ((i + 1) until size)) {
                cursorTotal *= nums[j]
                cursorMax = max(cursorTotal, cursorMax)
            }
            maxRet = max(maxRet, cursorMax)
        }
        return maxRet
    }

    /**
     *
     */
    fun maxProduct(nums: IntArray): Int {
        val size = nums.size
        if (size == 1) {
            return nums[0]
        }
        var maxF = nums[0]
        var minF = nums[0]
        var ans = nums[0]
        for (i in 1 until size) {
            val mx = maxF
            val mn = minF
            maxF = max(mx * nums[i], max(nums[i], mn * nums[i]))
            minF = max(mn * nums[i], min(nums[i], mx * nums[i]))
            ans = max(maxF, ans)
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {

    }

}