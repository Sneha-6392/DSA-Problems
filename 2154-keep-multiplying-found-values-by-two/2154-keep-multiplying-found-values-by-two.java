class Solution {
    public int findFinalValue(int[] nums, int original) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i : nums){
            a.add(i);
        }
        for(int i : nums){
            if(a.contains(original)){
                original=2*original;
            }
        }
        return original;
        
    }
}