class Solution {
    Map<Integer, Integer> cache;
    
    public int rob(int[] nums) {
        cache = new HashMap<>();
        return recurse(nums, 0);
    }
    
    public int recurse(int[] nums, int pos) {
        if (cache.containsKey(pos)) {
            return cache.get(pos);
        }
        
        int ans;
        if (pos >= nums.length) {
            ans = 0;
        } else {
            ans = Math.max(
                recurse(nums, pos + 1),
                nums[pos] + recurse(nums, pos + 2)
            );
        }
        cache.put(pos, ans);
        return ans;
    }
}