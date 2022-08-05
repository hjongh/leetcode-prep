Uh. Basically the problem space is parameterized by two variables now - a position which splits the list, and also a boolean for whether or not the last house can be chosen.

Recursive solution still `O(2^n)`, and dp solution `O(n)`.

I kinda did this another way, I just modified the inputs and basically ran `House Robber I` twice on different inputs. Lazy.