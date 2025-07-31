class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+ 1);
        }
        int m = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n){
                m = entry.getKey();
            }
        }
        return m;
    }
}