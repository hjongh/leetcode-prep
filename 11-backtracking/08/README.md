Yeah so the very first solution I came up with is the backtracking solution. Actually, the backtracking solution is just a fancy way to call the brute force solution, in this case.

I couldn't really come up with a good time complexity before solving the problem. The given constraints on the input size is pretty small.

At minimum I suppose its 2^n. Like, if you could only use a candidate once, it would be 2^n. Although the search tree would be pruned whenever the running sum is greater than target.

Here's an interesting post found in the discussion for this question where someone provides a template for backtracking in different scenarios - subsets, permutations, combinations, etc:
https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
