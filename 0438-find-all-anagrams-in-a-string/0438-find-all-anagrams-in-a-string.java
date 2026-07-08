class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> arr = new ArrayList<>();

        if (s.length() < p.length()) {
            return arr;
        }

        int[] fp = new int[26];
        for (int i = 0; i < p.length(); i++) {
            fp[p.charAt(i) - 'a']++;
        }

        int[] fs = new int[26];
        int k = p.length();

        for (int i = 0; i < k; i++) {
            fs[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(fp, fs)) {
            arr.add(0);
        }

        for (int i = k; i < s.length(); i++) {
            fs[s.charAt(i - k) - 'a']--;
            fs[s.charAt(i) - 'a']++;

            if (Arrays.equals(fp, fs)) {
                arr.add(i - k + 1);
            }
        }

        return arr;
    }
}