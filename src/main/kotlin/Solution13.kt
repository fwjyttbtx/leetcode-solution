object Solution13 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var minLen = strs[0].length
        strs.forEach { s -> if (s.length < minLen) minLen = s.length }
        var ret = ""
        repeat(minLen) { i ->
            val charInPos = strs[0][i]
            for(si in 1 until strs.size) {
                val s = strs[si]
                if (charInPos == s[i]) continue
                else return ret
            }
            ret += charInPos
        }
        return ret
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(longestCommonPrefix(arrayOf("flower","flow","flight")))
    }

}