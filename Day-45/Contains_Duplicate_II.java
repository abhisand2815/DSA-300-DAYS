class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If duplicate found in window
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // Maintain window size k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
