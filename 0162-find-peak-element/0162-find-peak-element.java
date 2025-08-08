class Solution {
    public int findPeakElement(int[] nums) {
        int val=0;
        // if(nums.length==2){
        //     return 1;
        // }
        for(int i=1; i<=nums.length-1; i++){
            if(nums[i]>nums[i-1]){
                val=i;
            }
        }
        System.out.println(val);
        return val;
    }
}