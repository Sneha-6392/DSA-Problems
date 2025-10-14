class Solution {
    public boolean isincr(List<Integer> nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i + 2 * k <= n; i++) {
            if (isincr(nums, i, i + k - 1) && isincr(nums, i + k, i + 2 * k - 1)) {
                return true;
            }
        }
        return false;
    }
}