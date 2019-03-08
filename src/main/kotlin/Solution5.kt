object Solution5 {

    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        val sLen = s.length
        var palindromeStr = "${s[0]}"
        s.forEachIndexed { i, ch ->
            if (i == 0) return@forEachIndexed
            // 检查字符串前一个和后一个是否是相同字符串如果是
            val prevIdx = i - 1
            val nextIdx = i + 1
            // 需要对当前字符与前一个字符相同以及当前字符和前后字符都相同的条件做分别判断查询
            if (s[prevIdx] == ch) {
                var evenSeek = ""
                var evenPrev = prevIdx
                var evenNext = nextIdx - 1
                if (evenPrev < 0 || evenNext >= sLen) return palindromeStr
                while (evenPrev >= 0 && evenNext < sLen) {
                    if (s[evenPrev] == s[evenNext]) evenSeek = "${s[evenPrev--]}$evenSeek${s[evenNext++]}"
                    else break
                }
                if (evenSeek.length > palindromeStr.length) palindromeStr = evenSeek
            }
            if (prevIdx < 0 || nextIdx >= sLen) return palindromeStr
            if (s[prevIdx] == s[nextIdx]) {
                var oddSeek = "$ch"
                var oddPrev = prevIdx
                var oddNext = nextIdx
                while (oddPrev >= 0 && oddNext < sLen) {
                    if (s[oddPrev] == s[oddNext]) oddSeek = "${s[oddPrev--]}$oddSeek${s[oddNext++]}"
                    else break
                }
                if (oddSeek.length > palindromeStr.length) palindromeStr = oddSeek
            }
        }
        return palindromeStr
    }

    fun longestPalindrome2(s: String): String {
        if (s.isEmpty()) return ""
        fun expandAroundCenter(s: String, left: Int, right: Int): Int {
            var l = left
            var r = right
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l++
                r--
            }
            return r - l - 1
        }

        var start = 0
        var end = 0
        for (i in 0 until s.length - 1) {//i 不用跑到最后一个字符上(无意义)
            //情况一:'bb'
            //情况二:'aba'
            //重置数值
            val len1 = expandAroundCenter(s, i, i)
            val len2 = expandAroundCenter(s, i, i + 1)
            val len = Math.max(len1, len2)
            if (len > (end - start)) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)
    }

    fun longestPalindrome3(s: String): String {
        if (s.isEmpty()) return s
        var start = 0
        var end = 0
        fun expandAround(s: String, l: Int, r: Int): Int {
            var sl = l
            var sr = r
            while (sl >= 0 && sr < s.length && s[sl] == s[sr]) {
                sl--
                sr++
            }
            return sr - sl - 1
        }
        for (i in 0..(s.length - 2)) {
            val sa = expandAround(s, i, i)
            val sb = expandAround(s, i, i + 1)
            val len = Math.max(sa, sb)
            if (len > (end - start)) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(longestPalindrome2("bbbzzzzzzzzzzddd"))
    }

}