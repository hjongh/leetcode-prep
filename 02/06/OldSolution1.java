class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int rob(int[] nums) {
        return Math.max(
            nums[0] + robSubproblem(2, nums.length - 2, nums),
            robSubproblem(1, nums.length - 1, nums)
        );
    }
    
    private int robSubproblem(int start, int end, int[] nums) {
        if (start > end) {
            return 0;
        } else {
            int cacheSubproblemId = getCacheSubproblemId(start, end);
            if (cache.containsKey(cacheSubproblemId)) {
                return cache.get(cacheSubproblemId);
            }
            
            int ans = Math.max(
                nums[start] + robSubproblem(start + 2, end, nums),
                robSubproblem(start + 1, end, nums)
            );
            cache.put(cacheSubproblemId, ans);
            return ans;
        }
    }
                   
    private int getCacheSubproblemId(int start, int end) {
        return 1000 * start + end;
    }
}