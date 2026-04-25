class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapST = new int[256]; // s -> t
        int[] mapTS = new int[256]; // t -> s

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // if mapping not exists, create it
            if (mapST[c1] == 0 && mapTS[c2] == 0) {
                mapST[c1] = c2;
                mapTS[c2] = c1;
            }
            // if mapping mismatch
            else {
                if (mapST[c1] != c2 || mapTS[c2] != c1) {
                    return false;
                }
            }
        }

        return true;
    }
}
