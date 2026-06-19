class Solution {
    public int minMutation(String start, String end, String[] bank) {

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(start);
        endSet.add(end);

        char[] genes = {'A', 'C', 'G', 'T'};
        int steps = 0;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // always expand smaller set
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            for (String curr : beginSet) {
                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];

                    for (char g : genes) {
                        arr[i] = g;
                        String next = new String(arr);

                        if (endSet.contains(next)) return steps + 1;

                        if (bankSet.contains(next)) {
                            nextSet.add(next);
                            bankSet.remove(next); // mark visited
                        }
                    }

                    arr[i] = old;
                }
            }

            beginSet = nextSet;
            steps++;
        }

        return -1;
    }
}
