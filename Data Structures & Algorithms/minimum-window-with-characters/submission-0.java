class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[126];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = t.length();
        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            if (need[ch] > 0) {
                required--;
            }
            need[ch]--;

            while (required == 0) {
                int windowLen = right - left + 1;

                if (windowLen < minLen) {
                    minLen = windowLen;
                    start = left;
                }

                char lc = s.charAt(left);
                need[lc]++;

                if (need[lc] > 0) {
                    required++;
                }

                left++;

            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
