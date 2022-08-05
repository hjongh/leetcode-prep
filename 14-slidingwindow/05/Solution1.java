// Sliding window solution

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            
            if (!window.contains(c)) {
                window.add(c);
            } else {
                while (window.contains(c)) {
                    window.remove(s.charAt(left));
                    left++;
                }
                window.add(c);
            }
            
            ans = Math.max(ans, right - left + 1);
            
            right++;
        }
        
        return ans;
    }
}