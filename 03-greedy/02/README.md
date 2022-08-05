https://leetcode.com/problems/task-scheduler/

So we can reduce the state of this problem to a mapping of tasks -> counts. And the problem is solved when the counts of all tasks are 0.

So you could do a backtracking approach where at each step, you try picking all the possible letters (and idle if you can't due to cooldowns).

Thats O(n!).

Okay so instead of getting overwhelmed and panicking. Let's try and be methodical. I had the idea that it could be optimal to always attempt to choose the task with the highest remaining count, if possible.

What really helped is going through the examples and looking at one with different counts for each task. And seeing how my brain intuitively solves the problem.

Basically given a cooldown and a task count. You know the minimum number of steps it will take to bring that task count to 0: task count * cooldown. The minimum steps it will take to bring all the task counts to 0 is the maximum of all the minimum step counts.

-----

3A 2B 2C. n = 1

A B A B A C idle C
A B A C A B C
A B C A idle A

A B C A B C A

4A 3B 3C

A B A C A B A C
