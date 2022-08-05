class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(r, c, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int depth, char[][] board, String target) {
        if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && !visited[r][c] && target.charAt(depth) == board[r][c]) {
            // found a match
            if (depth == target.length() - 1) {
                return true;
            }

            visited[r][c] = true;

            boolean ans = dfs(r + 1, c, depth + 1, board, target) ||
                    dfs(r - 1, c, depth + 1, board, target) ||
                    dfs(r, c + 1, depth + 1, board, target) ||
                    dfs(r, c - 1, depth + 1, board, target);

            visited[r][c] = false;
            return ans;
        } else {
            return false;
        }
    }
}