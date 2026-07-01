class Solution {
    public int absDifference(int[] nums, int k) {
        int small = 0;
        int large = 0;
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        while (i < k && j >= k) {
            small += nums[i];
            large += nums[j];
            i++;
            j--;
        }
        return Math.abs(large - small);
    }
}