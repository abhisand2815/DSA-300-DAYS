class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Step 1: build graph
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        // Step 2: process queries
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                result[i] = dfs(graph, start, end, new HashSet<>(), 1.0);
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph,
                       String curr, String target,
                       Set<String> visited, double product) {

        if (curr.equals(target)) return product;

        visited.add(curr);

        for (String neighbor : graph.get(curr).keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfs(graph, neighbor, target, visited,
                                    product * graph.get(curr).get(neighbor));

                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }
}
