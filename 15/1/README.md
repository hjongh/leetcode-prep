So its pretty simple, if theres a valid topological sort then yes, otherwise no.

So initially I thought that if the graph is disconnected, or has a cycle, it won't have a topological sort. But, a disconnected graph can definitely have a topological sort.

So the only question here is, is there ever a cycle?

So one way is to do a DFS from every node and see if there's a cycle. But that's O(n^2) time complexity. We can do easier way, removing duplicated work. Basically do a flood fill. Once we've found that a node is part of a prior dfs search, we don't have to check again because if there was a cycle from the root of the prior dfs search we would've caught it.

So we build adjacency lists. And then do flood fill.

# additional comments

So actually a simple flood fill deosn't work. You have to use temporary/permanent mark pattern that's used in the dfs algorithm to find topological sort. Check wikipedia

And you don't need to find different regions in flood fill... just need to check visited or not
