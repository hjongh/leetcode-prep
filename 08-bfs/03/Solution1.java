// Bit of an ugly solution imo. DFS.

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    Map<Node, Node> clones = new HashMap<>();
    Set<Node> visited = new HashSet<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        clones.put(node, new Node(node.val));
        dfs(node);
        return clones.get(node);
    }
    
    private void dfs(Node node) {
        visited.add(node);
        
        for (Node neighbor : node.neighbors) {
            if (!clones.containsKey(neighbor)) {
                clones.put(neighbor, new Node(neighbor.val));
            }
            clones.get(node).neighbors.add(clones.get(neighbor));
            
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }
}