class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int min=Integer.MAX_VALUE;
            max=Math.max(max,nums[i]);
            for(int j=i;j<nums.length;j++){
                min=Math.min(min,nums[j]);
            }
            int temp=max-min;
            if(temp<=k){
                ans=Math.min(ans,i);
            }
        }
        if(ans==2147483647) return -1;
        return ans;
    }
}