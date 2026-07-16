class Solution {
    public int countDigits(int n) {
        int num = n;
        int cnt = 0;
        while (n != 0) {
            int digit = n % 10;
            if (num % digit == 0) {
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }
}