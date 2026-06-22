class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word
    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }

        node.isEnd = true;
    }

    // Search with optimization
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (node == null) return false;

        if (i == word.length()) return node.isEnd;

        char c = word.charAt(i);

        if (c != '.') {
            return dfs(word, i + 1, node.children.get(c));
        }

        // '.' case → only iterate existing children
        for (TrieNode child : node.children.values()) {
            if (dfs(word, i + 1, child)) return true;
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */