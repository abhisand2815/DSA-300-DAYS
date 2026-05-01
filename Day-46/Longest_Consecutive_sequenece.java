class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // Add all numbers to set
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            // Only start if it's beginning of sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                // Count forward
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }
}
