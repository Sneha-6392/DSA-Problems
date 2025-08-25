class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int k=0;
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            if(freq.get(i)==1)
            return i;
        }
        return 0;
    }
}