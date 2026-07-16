class Solution {
    public int reverse(int n) {
        long rev = 0;
        while (n != 0) {
            long digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) rev;
    }
}