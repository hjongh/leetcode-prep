Not really a sliding window problem in my book!
Helps to think about how to parameterize the solution space.

First I thought it was 2^n to represent all the possible binary states. But you have to realize that not all of them can be reached from the current state.

There's a solution on leetcode by a white guy which explains that you would never a flip a given window more than once (cause you just go back to the start) and since there's `n-k` possible windows, the problem space is actually 2^(n-k).

But then, you can solve the problem with a greedy approach. This is another tough jump to make in logic. Hm..

Basically, if you realize that whenever you encounter a 0 at position i, you MUST make the flip of window [i,i+k], then you can consider a greedy approach.

Really tough problem to be honest!