class Solution {
    public int trailingZeroes(int n) {
        if (n == 0)
            return 0;

        int ans = 0;
        while (n != 0) {
            int result = n / 5;
            n = result;
            ans += result;
        }
        return ans;
    }
}