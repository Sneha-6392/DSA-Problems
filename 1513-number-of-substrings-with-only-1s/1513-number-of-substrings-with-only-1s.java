class Solution {
    public int numSub(String s) {
        final int mod = 1000000007;
        long ans = 0;
        long count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
                ans = (ans + count) % mod;
            }
            else {
                count = 0;
            }
        }
        return (int) ans;
    }
}