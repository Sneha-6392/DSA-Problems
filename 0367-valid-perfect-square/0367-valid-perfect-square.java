class Solution {
    public boolean isPerfectSquare(int num) {
        int root = (int) Math.sqrt(num);
        if (root * root == num) {
            return true;
        }
        return false;
    }
}