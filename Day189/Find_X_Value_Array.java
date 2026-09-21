class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at previous position
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            // Start a new subarray with nums[i]
            next[num % k]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int nr = (int)((r * (long)(num % k)) % k);
                    next[nr] += dp[r];
                }
            }

            // Add all subarrays ending at current position
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }
}
