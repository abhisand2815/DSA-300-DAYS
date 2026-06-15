
class Solution {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // already cloned
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // create new node
        Node clone = new Node(node.val);
        map.put(node, clone);

        // clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
