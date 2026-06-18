class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n) return moves;

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {

                    int[] pos = getPosition(next, n);
                    int r = pos[0], c = pos[1];

                    int destination = (board[r][c] == -1) ? next : board[r][c];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    // convert number → board position
    private int[] getPosition(int num, int n) {
        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;

        // reverse direction for alternate rows
        if (((n - row) % 2) == 0) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}
