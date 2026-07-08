class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int st = 1;
        int ed = nums.length - 2;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                st = mid + 1;
            }
            else {
                ed = mid - 1;
            }
        }
        return -1;
    }
}