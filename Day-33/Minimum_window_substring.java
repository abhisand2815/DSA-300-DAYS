class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128]; // ASCII
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            // If char is needed, decrease count
            if (need[s.charAt(right)] > 0) {
                count--;
            }
            need[s.charAt(right)]--;

            // When all chars matched
            while (count == 0) {
                // Update result
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Try to shrink window
                need[s.charAt(left)]++;
                if (need[s.charAt(left)] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE 
               ? "" 
               : s.substring(start, start + minLen);
    }
}
