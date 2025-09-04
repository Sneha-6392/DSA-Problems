class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        arr[0] = find(nums, target, false);
        if(arr[0] != -1){
            arr[1] = find(nums, target, true);
        } 
        return arr;
    }
    public int find(int[] nums, int target, boolean ans) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                if (ans) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return res;
    }
}