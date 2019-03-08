import java.lang.IllegalArgumentException

//给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
//
//'.' 匹配任意单个字符。
//'*' 匹配零个或多个前面的元素。
//匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
//
//说明:
//
//s 可能为空，且只包含从 a-z 的小写字母。
//p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
object Solution10 {
    fun isMatch(s: String, p: String): Boolean {
        val sLen = s.length
        val pLen = p.length
        val memory = Array(sLen + 1) { BooleanArray(pLen + 1) }
        memory[0][0] = true
        for (i in 0..sLen) {
            for(j in 1..pLen) {
                if (p[j - 1] == '*') {
                    memory[i][j] = memory[i][j-2] || (i > 0 && (s[i-1] == p[j-2] || p[j-2] == '.') && memory[i-1][j])
                } else {
                    memory[i][j] = i > 0 && (s[i-1] == p[j-1] || p[j-1] == '.') && memory[i-1][j-1]
                }
            }
        }
        return memory[sLen][pLen]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isMatch("mississippi", "mis*is*p*."))
    }

}