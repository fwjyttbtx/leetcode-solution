class Solution3 {

    fun lengthOfLongestSubstring(s: String): Int {
        var maxUniq = 0
        val chs = mutableListOf<Char>()
        s.forEach { ch ->
            if (chs.contains(ch)) {
                val uniqSub = chs.toList().subList(chs.indexOf(ch) + 1, chs.size)
                if (maxUniq < chs.size) {
                    maxUniq = chs.size
                }
                chs.clear()
                chs.addAll(uniqSub)
            }
            chs.add(ch)
        }
        if (maxUniq < chs.size) {
            maxUniq = chs.size
        }
        return maxUniq
    }

}
