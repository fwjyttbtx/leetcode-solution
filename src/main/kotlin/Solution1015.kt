object Solution1015 {

    fun numDupDigitsAtMostN(N: Int): Int {
        val n = N.toString().toCharArray()
        var all = 0
        var nsize = n.size
        while(nsize >= 2) {
            when(nsize) {
                n.size -> {
//                    all += counts(n[0], n)
                     ('1'..n[0]).forEach { nch -> all += counts(nch, n) }
                }
                else -> {
                    // 构造99..的字符串数组
                    val charArr = CharArray(nsize)
                    repeat(nsize) { i -> charArr[i] = '9' }
//                    all += counts('9', charArr)
                     ('1'..charArr[0]).forEach { nch -> all += counts(nch, charArr) }
                }
            }
            nsize--
        }
        return all
    }

    private fun counts(n: Char, narr: CharArray): Int {
        // 传入首位数字,检查narr的数字可能存在的重复数字的统计
        // 假设n是9 则后续数字有0-9的重复可能 首位不能为0
        var all = 0
        val subarr = narr.toMutableList().subList(1, narr.size)
        val zeroCounts = subarr.count { nch -> nch >= '0' }
        all += Math.pow(2.0, zeroCounts.toDouble()).toInt() - zeroCounts - 1
        ('1'..n).forEach { ch ->
            val counts = narr.count { nch -> nch >= ch }
            all += Math.pow(2.0, counts.toDouble()).toInt() - counts - 1
//            while(counts >= 2) {
//                all += Math.pow(2.0, counts.toDouble()).toInt() - counts - 1
//                counts--
//            }
        }
        return all
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(numDupDigitsAtMostN(1_000_000_000))
    }
}