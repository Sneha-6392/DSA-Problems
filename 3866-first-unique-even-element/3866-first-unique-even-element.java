class Solution {
    public int firstUniqueEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && map.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return -1;
    }
}