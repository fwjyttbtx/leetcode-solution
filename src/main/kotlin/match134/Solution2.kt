package match134

object Solution2 {
    fun colorBorder(grid: Array<IntArray>, r0: Int, c0: Int, color: Int): Array<IntArray> {
        val target = grid[r0][c0]
        if (target == color) return grid
        grid[r0][c0] = color
        val right = r0 + 1
        val left = r0 - 1
        val top = c0 - 1
        val bottom = c0 + 1

        if (right < grid.size) {
            if (grid[right][c0] == target) colorBorder(grid, right, c0, color)
        }
        if (left >= 0) {
            if (grid[left][c0] == target) colorBorder(grid, left, c0, color)
        }
        if (top >= 0) {
            if (grid[r0][top] == target) colorBorder(grid, r0, top, color)
        }
        if (bottom < grid[0].size) {
            if (grid[r0][bottom] == target) colorBorder(grid, r0, bottom, color)
        }
        return grid
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            colorBorder(
                arrayOf(
                    intArrayOf(1, 2, 1, 2, 1, 2),
                    intArrayOf(2, 2, 2, 2, 1, 2),
                    intArrayOf(1, 2, 2, 2, 1, 2)
                ),
                1,
                3,
                1
            ).joinToString(separator = "\r\n") { it.joinToString(prefix = "[", postfix = "]") }
        )
    }

}