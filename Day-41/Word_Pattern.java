class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // If mapping doesn't exist, create it
            if (!map1.containsKey(c) && !map2.containsKey(word)) {
                map1.put(c, word);
                map2.put(word, c);
            } 
            // If mapping exists but doesn't match → false
            else {
                if (!word.equals(map1.get(c)) || map2.get(word) != c) {
                    return false;
                }
            }
        }

        return true;
    }
}
