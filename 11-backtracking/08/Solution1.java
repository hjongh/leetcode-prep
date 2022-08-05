class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, 0, target, new ArrayList<>());
        return ans;
    }
    
    private void backtracking(int[] candidates, int currentIndex, int currentSum, int target, List<Integer> currCombo) {
        if (currentIndex < candidates.length) {
            if (currentSum == target) { // found a solution
                ans.add(new ArrayList<>(currCombo));
            } else if (currentSum < target) { // continue backtracking
                // 2 choices - add current candidate, or move to next candidate
                currentSum += candidates[currentIndex];
                currCombo.add(candidates[currentIndex]);
                backtracking(candidates, currentIndex, currentSum, target, currCombo);
                currCombo.remove(currCombo.size() - 1);
                currentSum -= candidates[currentIndex];
                
                backtracking(candidates, currentIndex + 1, currentSum, target, currCombo);
            }
        }
    }
}