/**
 * again, I do one extra step of iteration on each branch which is unnecessary
 *
 * also, the way I build strings is inefficient... adds extra time complexity
 */
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>();
        recursiveEnumeration(s, 0, "", answers);
        return answer;
    }

    private void recursiveEnumeration(String s, int pos, String curr, List<String> answer) {
        if (pos < s.length()) {
            char c = s.charAt(pos);
            if (Character.isDigit(c)) {
                recursiveEnumeration(s, pos + 1, curr + c, answer);
            } else {
                recursiveEnumeration(s, pos + 1, curr + Character.toUpperCase(c), answer);
                recursiveEnumeration(s, pos + 1, curr + Character.toLowerCase(c), answer);
            }
        } else {
            answer.add(curr);
        }
    }
}