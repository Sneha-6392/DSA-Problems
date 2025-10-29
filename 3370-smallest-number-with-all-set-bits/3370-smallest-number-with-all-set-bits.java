class Solution {
    public int smallestNumber(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int count = 0;
        int num = n;
        while (n > 0) {
            n /= 2;
            count++;
        }
        int bit = (int)(Math.pow(2, count)) - 1;
        if (num == bit) {
            return num;
        }
        return bit;
    }
}




