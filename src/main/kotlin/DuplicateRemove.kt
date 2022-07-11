object DuplicateRemove {

    fun removeDuplicates(S: String): String {
        val ret: MutableList<Char> = mutableListOf();
        S.forEach {
            if (ret.size > 0) {
                val pre: Char = ret.last()
                if (pre == it) {
                    ret.removeAt(ret.size - 1)
                } else {
                    ret.add(it)
                }
            } else {
                ret.add(it)
            }
        }
        return ret.joinToString(separator = "")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(removeDuplicates("abbaca"))
    }

}