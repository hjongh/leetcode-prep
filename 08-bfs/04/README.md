Basically, BFS.

`O(n)` time and space complexity.

Almost feels like a waste of my time to code it up in all honesty.

---

Ok so that's what I used to think, but now I realize that it's not that simple.

Basically, to know whether rain flows from a given square to both oceans, you need to run BFS on that square and check whether the recursion picks up at least one pacific square and at least one atlantic square. Since you need to know this for all squares, you actually need to run BFS once for each square.

Now, there's a way to reduce some duplicated work by reusing answers. For example instead of redoing a BFS from a given square for every round of BFS, you could cache that result and then reuse it. This would result in an O(n) solution.

Alternatively, you could flood from the ocean. But this would also require you to do multiple BFS.