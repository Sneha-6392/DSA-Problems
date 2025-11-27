import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int target,
                           List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);               
            backtrack(i, candidates, target - candidates[i], current, result);  
            current.remove(current.size() - 1);          
        }
    }
}
