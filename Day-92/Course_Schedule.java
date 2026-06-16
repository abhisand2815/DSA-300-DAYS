class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        int[] state = new int[numCourses]; // 0,1,2

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, state, i)) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return false; // cycle
        if (state[node] == 2) return true;  // already safe

        state[node] = 1; // visiting

        for (int neighbor : graph.get(node)) {
            if (!dfs(graph, state, neighbor)) return false;
        }

        state[node] = 2; // done
        return true;
    }
}
