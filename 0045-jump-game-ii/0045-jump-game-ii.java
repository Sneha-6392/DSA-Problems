class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int cur = 0;
        int far = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == cur) {
                jump++;
                cur = far;
            }
        }
        return jump;
    }
}