class Solution {
    public int countPrimes(int n) {
        boolean[] seen = new boolean[n];
        int ans = 0;

        for (int i = 2; i < n; i++) {
            if (seen[i] == true) continue;
            ans++;

            for (long j = (long) i * i; j < n; j += i) {
                seen[(int) j] = true;
            }
        }
        return ans;
    }
}