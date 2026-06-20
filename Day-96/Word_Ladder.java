import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // Step 1: build pattern map
        Map<String, List<String>> map = new HashMap<>();

        int L = beginWord.length();

        for (String word : wordSet) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // Step 2: BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) return steps;

                for (int j = 0; j < L; j++) {
                    String pattern = curr.substring(0, j) + "*" + curr.substring(j + 1);

                    for (String nei : map.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}
