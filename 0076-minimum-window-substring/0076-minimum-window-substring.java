import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0, required = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (freq[c] > 0) required--;
            freq[c]--;
            right++;

            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);
                freq[lc]++;
                if (freq[lc] > 0) required++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
