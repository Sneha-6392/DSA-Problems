class Solution {
    public int closestTarget(String[] words, String target, int si) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int next = (i - si + n) % n;
                int prev = (si - i + n) % n;
                ans = Math.min(ans, Math.min(next, prev));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}