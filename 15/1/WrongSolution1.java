// This solution fails on input:
// 4
// [[1,0],[2,0],[3,1],[3,2]]
// It returns false when it should return true.
// This is because cycles in directed graphs are different than non-directed graphs.
// This is why you need to use the temporary/permament mark that's used in the topological version of DFS: https://en.wikipedia.org/wiki/Topological_sorting
// And mark temporary on the way down, and permanent on the way up the recursion stack
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build our adjacency list
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            neighbors.get(prereq[1]).add(prereq[0]);
        }
        
        int[] floodRegion = new int[numCourses];
        int region = 1;
        for (int i = 0; i < numCourses; i++) {
            if (floodRegion[i] == 0 && existsCycleAndFlood(i, region, floodRegion, neighbors)) {
                return false;
            }
            region++;
        }
        
        return true;
    }
    
    boolean existsCycleAndFlood(int currNode, int region, int[] floodRegion, List<List<Integer>> neighbors) {
        if (floodRegion[currNode] == 0) { // if we haven't visited this node in a prior flood
            floodRegion[currNode] = region;
            boolean existsCycle = false;
            for (int neighbor : neighbors.get(currNode)) {
                existsCycle = existsCycle || existsCycleAndFlood(neighbor, region, floodRegion, neighbors);
            }
            return existsCycle;
        } else if (floodRegion[currNode] == region) {
            return true;
        } else {
            return false;
        }
    }
}