class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        int index = 0;
        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            if (index < nums.length && nums[index] == i) {
                index++;
            } else {
                arr.add(i);
            }
        }
        return arr;
    }
}