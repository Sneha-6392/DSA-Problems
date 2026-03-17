class Solution {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int a = 3;
        int b = 2;
        int c = 0;
        for (int i = 3; i < n; i++) {
            c = a + b;
            b = a;
            a = c;
        }
        return c;
    }
}