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
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && existsCycleAndMarkVisited(i, visited, neighbors)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean existsCycleAndMarkVisited(int currNode, int[] visited, List<List<Integer>> neighbors) {
        if (visited[currNode] == -1) { // this is the temporary mark
            return true;
        } else if (visited[currNode] == 0) { // if we haven't visited this node in a prior search
            visited[currNode] = -1;
            boolean existsCycle = false;
            for (int neighbor : neighbors.get(currNode)) {
                existsCycle = existsCycle || existsCycleAndMarkVisited(neighbor, visited, neighbors);
            }
            visited[currNode] = 1;
            return existsCycle;
        } else { //visited[currNode] = 1
            return false;
        }
    }
}