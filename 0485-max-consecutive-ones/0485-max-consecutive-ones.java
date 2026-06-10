class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count += 1;
            }
            else {
                count = 0;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}