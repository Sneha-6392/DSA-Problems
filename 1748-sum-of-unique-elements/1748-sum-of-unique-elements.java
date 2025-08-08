class Solution {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                sum+=entry.getKey();
            }
        }
        return sum;
    }
}