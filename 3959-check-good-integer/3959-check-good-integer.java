class Solution {
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int squareSum = 0;
        while (n != 0) {
            digitSum += n % 10;
            squareSum += (int) Math.pow((n % 10), 2);
            n /= 10;
        }
        if (squareSum - digitSum >= 50) {
            return true;
        }
        return false;
    }
}