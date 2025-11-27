class Solution {
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    public void recursion(int[] nums, List<Integer> ans, List<List<Integer>> result, int i){
        if(i == nums.length){ 
            if(!set.contains(ans)){ 
                result.add(new ArrayList<>(ans)); 
                set.add(new ArrayList<>(ans));
            }
            return;
        }
        ans.add(nums[i]);
        recursion(nums, ans, result, i+1);
        ans.remove(ans.size()-1); 

        recursion(nums, ans, result, i+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, new ArrayList<>(), result, 0);
        return result;
    }
}