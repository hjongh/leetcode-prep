/**
 * In general this solution is kinda messy. Also I do prune one branch of the search, I always
 * enter into a new stack frame unnecessarily on the end of a search branch.
 *
 * I think a helpful way to write the backtracking search is to think of the possible options
 * 1. return true
 * 2. return false
 * 3. continue the search
 * That will help you come up with working code.
 */
class Solution {

    private static char UNAVAILABLE = '0';

    public boolean exist(char[][] board, String word) {
        boolean exists = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                exists = exists || backtrackingSearch(board, word, r, c, 0);
            }
        }
        return exists;
    }

    public boolean backtrackingSearch(char[][] board, String word, int r, int c, int wordPos) {
        // this is messy, could factor sum of this stuff out into helper functions
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == UNAVAILABLE || board[r][c] != word.charAt(wordPos)) {
            return false;
        } else {
            if (wordPos == word.length() - 1) {
                return true;
            } else {
                board[r][c] = UNAVAILABLE;
                boolean exists = false;
                // there's duplicated code here
                exists = exists || backtrackingSearch(board, word, r + 1, c, wordPos + 1);
                exists = exists || backtrackingSearch(board, word, r, c + 1, wordPos + 1);
                exists = exists || backtrackingSearch(board, word, r - 1, c, wordPos + 1);
                exists = exists || backtrackingSearch(board, word, r, c - 1, wordPos + 1);
                board[r][c] = word.charAt(wordPos);
                return exists;
            }
        }
    }
}