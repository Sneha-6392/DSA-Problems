class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actualSum = n * (n + 1) / 2;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
        }
        return actualSum - currSum;
    }
}