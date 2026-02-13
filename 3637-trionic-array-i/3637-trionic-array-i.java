class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int p = 0;
        while(p <= n - 3 && nums[p] < nums[p + 1]) {
            p += 1;
        }
        if(p == 0) {
            return false;
        }
        int q = p;
        while(q <= n - 2 && nums[q] > nums[q + 1]) {
            q += 1;
        }
        if(q == n - 1 || q == p) {
            return false;
        }
        while(q < n -1 && nums[q] < nums[q + 1]) {
            q += 1;
        }
        return q == n - 1;
   }
}