class Solution {
    public int[] twoSum(int[] num, int target) {
        int[] ans = {-1, -1};
        int left = 0;
        int right = num.length - 1;

        while (left < right) {
            int total = num[left] + num[right];

            if (total == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }

            if (total > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return ans;
    }
}