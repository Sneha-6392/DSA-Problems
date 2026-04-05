class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int find = target - curr;

            if (map.containsKey(find)) {
                return new int[] {i, map.get(find)};
            }

            map.put(curr, i);
        }

        return null;
    }
}