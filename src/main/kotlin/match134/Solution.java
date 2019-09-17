package match134;

public class Solution {
    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int mark = grid[r0][c0];
        int[][] marka = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                marka[i][j] = 0;
        func(marka, grid, r0, c0, mark);
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (marka[i][j] == -1) grid[i][j] = color;
        return grid;
    }

    private static void func(int[][] marka, int[][] grid, int r0, int c0, int mark) {
        if (r0 >= 0 && r0 < grid.length && c0 >= 0 && c0 < grid[0].length) {
            if (mark == grid[r0][c0] && marka[r0][c0] == 0) {
                if (r0 - 1 >= 0 && r0 + 1 < grid.length && c0 - 1 >= 0 && c0 + 1 < grid[0].length) {
                    if (grid[r0 - 1][c0] == mark && grid[r0 + 1][c0] == mark && grid[r0][c0 + 1] == mark && grid[r0][c0 - 1] == mark) {
                        marka[r0][c0] = -2;
                    } else {
                        marka[r0][c0] = -1;
                    }
                } else {
                    marka[r0][c0] = -1;
                }
                func(marka, grid, r0 - 1, c0, mark);
                func(marka, grid, r0 + 1, c0, mark);
                func(marka, grid, r0, c0 - 1, mark);
                func(marka, grid, r0, c0 + 1, mark);
            }
        }

    }
}
