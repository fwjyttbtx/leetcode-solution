object Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val groups = mutableListOf<MutableList<Char>>(
            mutableListOf(), mutableListOf(), mutableListOf(),
            mutableListOf(), mutableListOf(), mutableListOf(),
            mutableListOf(), mutableListOf(), mutableListOf()
        )
        board.forEachIndexed { idx, line ->
            if (!checkListValid(line)) return false
            line.forEach { groups[idx].add(it) }
        }
        groups.forEach { if (!checkListValid(it.toCharArray())) return false }
        
        return true;
    }

    fun checkListValid(group: CharArray): Boolean {
        val validSet = mutableSetOf<Char>()
        group.forEach {
            if (it == '.') {
                return@forEach
            }
            if (!validSet.add(it)) {
                return false
            }
        }
        return true
    }

}