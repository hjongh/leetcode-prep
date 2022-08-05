So the whole issue with this question is that once you've used a square once, you can't use it again. So we need to store some extra state. Just to find the correct answer.

Hence the backtracking solution. You choose-explore-unchoose.

`m,n` are capped at 6, and `word.length` 15. But if they were uncapped, time complexity would be `m * n * 4^word.length`.

No extra space required. At most there will be `word.length` stack frames.

The whole reason we use choose-explore-unchoose is so that we don't have to copy the entire data structure that saves the state.

The state that we backtrack on requires 3 values - x coord, y coord, and what position we are in `word`. And, the table of which squares we've been to already.