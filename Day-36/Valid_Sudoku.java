class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (rows[i][num]++ > 0 ||
                    cols[j][num]++ > 0 ||
                    boxes[boxIndex][num]++ > 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
