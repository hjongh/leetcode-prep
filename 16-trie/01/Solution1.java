class Trie {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        
        public TrieNode() {
            children = new HashMap<>();
        }
    }
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        insertRecursive(root, word, 0);
    }
    
    private void insertRecursive(TrieNode node, String word, int pos) {
        if (pos == word.length()) {
            node.isWord = true;
        } else {
            char c = word.charAt(pos);
            if (node.children.containsKey(c)) {
                insertRecursive(node.children.get(c), word, pos + 1);
            } else {
                TrieNode newNode = new TrieNode();
                node.children.put(c, newNode);
                insertRecursive(newNode, word, pos + 1);
            }
        }
    }
    
    public boolean search(String word) {
        return searchRecursive(root, word, 0);
    }
    
    private boolean searchRecursive(TrieNode node, String word, int pos) {
        if (pos == word.length()) {
            return node.isWord;
        } else {
            char c = word.charAt(pos);
            if (!node.children.containsKey(c)) {
                return false;
            } else {
                return searchRecursive(node.children.get(c), word, pos + 1);
            }
        }
    }
    
    public boolean startsWith(String prefix) {
        return startsWithRecursive(root, prefix, 0);
    }
    
    private boolean startsWithRecursive(TrieNode node, String word, int pos) {
        if (pos == word.length()) {
            return true;
        } else {
            char c = word.charAt(pos);
            if (!node.children.containsKey(c)) {
                return false;
            } else {
                return startsWithRecursive(node.children.get(c), word, pos + 1);
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */