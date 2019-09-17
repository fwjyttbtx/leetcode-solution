object Solution13 {

    fun romanToInt(s: String): Int {
        val dict = mapOf(
            Pair('I', 1), Pair('V', 5), Pair('X', 10), Pair('L', 50), Pair('C', 100), Pair('D', 500), Pair('M', 1000)
        )
        var ret = 0
        s.forEachIndexed { i, ch ->
            if ((i + 1) < s.length && dict[ch]!! < dict[s[i + 1]]!!) {
                ret -= dict[ch]!!
            } else {
                ret += dict[ch]!!
            }
        }
        return ret
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(romanToInt("DCXXI"))
        println(romanToInt("MCMXCIV"))
        println(romanToInt("MMMCMXCIX"))
    }

//    fun longestCommonPrefix(strs: Array<String>): String {
//        if (strs.isEmpty()) return ""
//        var minLen = strs[0].length
//        strs.forEach { s -> if (s.length < minLen) minLen = s.length }
//        var ret = ""
//        repeat(minLen) { i ->
//            val charInPos = strs[0][i]
//            for(si in 1 until strs.size) {
//                val s = strs[si]
//                if (charInPos == s[i]) continue
//                else return ret
//            }
//            ret += charInPos
//        }
//        return ret
//    }
//
//    @JvmStatic
//    fun main(args: Array<String>) {
//        println(longestCommonPrefix(arrayOf("flower","flow","flight")))
//    }

}