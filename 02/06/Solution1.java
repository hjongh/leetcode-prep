class Solution {
    public int rob(int[] nums) {
        int[] numsWoutLast = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            numsWoutLast[i] = nums[i];
        }
        
        return Math.max(
            nums[0] + recurse(numsWoutLast, 2, new HashMap<>()),
            recurse(nums, 1, new HashMap<>())
        );
    }
    
    public int recurse(int[] nums, int pos, Map<Integer, Integer> cache) {
        if (cache.containsKey(pos)) {
            return cache.get(pos);
        }
        
        int ans;
        if (pos >= nums.length) {
            ans = 0;
        } else {
            ans = Math.max(
                recurse(nums, pos + 1, cache),
                nums[pos] + recurse(nums, pos + 2, cache)
            );
        }
        cache.put(pos, ans);
        return ans;
    }
}