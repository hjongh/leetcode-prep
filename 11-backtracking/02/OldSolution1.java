/**
 * My old code. It's much better because I backtrack when building strings instead of copying them/building new ones for every
 * recursive step.
 * Otherwise the logic is the same.
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        char[] currString = new char[S.length()];

        backtracking(currString, 0, S, ans);

        return ans;
    }

    private void backtracking(char[] currString, int currIndex, String orig, List<String> ans) {
        if (currIndex == orig.length()) {
            ans.add(new String(currString));
        } else {
            char currChar = orig.charAt(currIndex);
            if (Character.isLetter(currChar)) {
                currString[currIndex] = Character.toUpperCase(currChar);
                backtracking(currString, currIndex + 1, orig, ans);
                currString[currIndex] = Character.toLowerCase(currChar);
                backtracking(currString, currIndex + 1, orig, ans);
            } else {
                currString[currIndex] = currChar;
                backtracking(currString, currIndex + 1, orig, ans);
            }
        }
    }
}