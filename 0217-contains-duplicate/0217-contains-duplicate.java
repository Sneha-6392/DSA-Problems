class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : freq.values()) {
            if (i >= 2) {
                return true;
            }
        }
        return false;
    }
}