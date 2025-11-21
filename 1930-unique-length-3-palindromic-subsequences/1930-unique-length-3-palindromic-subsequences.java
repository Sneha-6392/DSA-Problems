class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) first[idx] = i;
            last[idx] = i;
        }

        int count = 0;

        for (int ch = 0; ch < 26; ch++) {
            if (last[ch] - first[ch] < 2) continue;

            Set<Character> set = new HashSet<>();
            for (int i = first[ch] + 1; i < last[ch]; i++) {
                set.add(s.charAt(i));
            }
            count += set.size();
        }

        return count;
    }
}
