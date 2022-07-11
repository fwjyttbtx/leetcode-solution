object Solution1190 {
    fun reverseParentheses(s: String): String {
        val lChs = mutableListOf<MutableList<Char>>()
        val rChs = mutableListOf<MutableList<Char>>()
        var temp = mutableListOf<Char>()
        s.forEach { ch ->
            if (ch != '(' && ch != ')') temp.add(ch)
            if (ch == '(') {
                lChs.add(temp)
                temp = mutableListOf()
            } else if (ch == ')') {
                rChs.add(temp)
                temp = mutableListOf()
            }
        }
        if (temp.isNotEmpty()) rChs.add(temp)
        var rst = ""
        rChs.forEachIndexed { index, r ->
            if (index == 0) rst += r.reversed().joinToString(separator = "")
            else {
                rst += r.reversed()
                if (lChs.isNotEmpty()) {
                    val lLast = lChs.last()
                    rst += lLast.reversed()
                    lChs.remove(lLast)
                }
            }
        }
        return rst.toString()
    }
    @JvmStatic
    fun main(args: Array<String>) {
        println(reverseParentheses("(ed(et(oc))el)"))
    }
}