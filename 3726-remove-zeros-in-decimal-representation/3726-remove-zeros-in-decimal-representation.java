class Solution {
    public long removeZeros(long n) {
        long num = 0;
        long place = 1;
        while (n != 0) {
            long rem = n % 10;
            if (rem != 0) {
                num = num + rem * place;
                place *= 10;
            }
            n /= 10;
        }
        return num;
    }
}