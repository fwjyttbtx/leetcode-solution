package hashtable

object GroupAnagrams {
    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        return strs.groupBy { it.toCharArray().sorted() }.map { it.value }
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val charMap = mapOf(
            Pair('a', 2), Pair('b', 3), Pair('c', 5), Pair('d', 7), Pair('e', 11),
            Pair('f', 13), Pair('g', 17), Pair('h', 19), Pair('i', 23), Pair('j', 29),
            Pair('k', 31), Pair('l', 37), Pair('m', 41), Pair('n', 43), Pair('o', 47),
            Pair('p', 53), Pair('q', 59), Pair('r', 61), Pair('s', 67), Pair('t', 71),
            Pair('u', 73), Pair('v', 79), Pair('w', 83), Pair('x', 89), Pair('y', 97),
            Pair('z', 101)
        )
        return strs.groupBy { str ->
            str.toCharArray().fold(initial = 1) { value, ch ->
                (charMap[ch] ?: 1) * value
            }
        }.values.toList()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val set = mutableSetOf<List<Char>>()
        set.add(listOf('b', 'a', 'c').sorted())
        set.add(listOf('a', 'b', 'c').sorted())
        println(groupAnagrams(arrayOf("abc", "cba", "eat", "tae", "tea", "cab", "cabc", "ccab", "cbac", "cbbcac", "cccbba")))
    }

}