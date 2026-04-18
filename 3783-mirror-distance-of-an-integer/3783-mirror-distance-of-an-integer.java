class Solution {
    public int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev *= 10;
            rev += n % 10;
            n /= 10;
        }
        return rev;
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
}