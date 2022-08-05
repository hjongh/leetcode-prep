/**
 * My old code.
 *
 * Note I have an extra String. This is redundant. The problem state can be reduced to one a number instead of a string.
 *
 * I also have an extra array of booleans to keep track of where we visited. This is probably better style but unnecessary here.
 *
 * Also some minor code style differences.
 */
class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(r, c, "", board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, String curr, char[][] board, String target) {
        if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && !visited[r][c]) {
            visited[r][c] = true;
            curr += board[r][c];

            if (curr.equals(target)) {
                return true;
            }

            boolean ans = false;
            if (curr.equals(target.substring(0, curr.length()))) {
                ans = ans ||
                        dfs(r + 1, c, curr, board, target) ||
                        dfs(r - 1, c, curr, board, target) ||
                        dfs(r, c + 1, curr, board, target) ||
                        dfs(r, c - 1, curr, board, target);
            }

            visited[r][c] = false;
            return ans;
        } else {
            return false;
        }
    }
}