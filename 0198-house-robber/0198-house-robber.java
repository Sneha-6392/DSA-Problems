class Solution {
    public int rob(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for (int i : nums) {
            int temp = Math.max(i + p2, p1);
            p2 = p1;
            p1 = temp;
        }
        return p1;
    }
}