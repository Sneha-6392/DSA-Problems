class Solution {
    public int maxSubArray(int[] nums) {
        int result=nums[0];
        int maxn=nums[0];
        for(int i=1; i<nums.length; i++){
            maxn=Math.max(maxn+nums[i], nums[i]);
            result=Math.max(maxn, result);
        }
        return result;
    }
}