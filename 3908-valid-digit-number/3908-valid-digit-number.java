class Solution {
    public boolean validDigit(int n, int x) {
        boolean flag = false;
        while (n >= 10) {
            int rem = n % 10;
            if (rem == x) {
                flag = true;
            }
            n /= 10;
        }
        return flag && n != x;
    }
}