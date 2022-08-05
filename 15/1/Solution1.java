// flood fill, but uses the temporary/permanent mark system for topological sort
// thing is, the different regions are unnecessary... you can just use the "visited" system
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
        if (floodRegion[currNode] == -1) { // this is the temporary mark
            return true;
        } else if (floodRegion[currNode] == 0) { // if we haven't visited this node in a prior flood
            floodRegion[currNode] = -1;
            boolean existsCycle = false;
            for (int neighbor : neighbors.get(currNode)) {
                existsCycle = existsCycle || existsCycleAndFlood(neighbor, region, floodRegion, neighbors);
            }
            floodRegion[currNode] = region;
            return existsCycle;
        } else {
            return false;
        }
    }
}