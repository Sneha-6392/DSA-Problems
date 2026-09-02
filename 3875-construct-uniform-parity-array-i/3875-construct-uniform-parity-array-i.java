class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        boolean odd = true, even = true;
        for(int i=0; i<n; i++){
            if(nums1[i]%2==0){
                boolean valid = false;
                for(int j=0; j<n; j++){
                    if(i!=j && Math.abs(nums1[i]-nums1[j])%2==1){
                        valid = true;
                    }
                }
                if(!valid) odd = false;
            }
            else {
                boolean valid = false;
                for(int j=0; j<n; j++){
                    if(i!=j && Math.abs(nums1[i]-nums1[j])%2==0){
                        valid = true;
                    }
                }
                if(!valid) even = false;
            }
        }
        return odd | even;
    }
}