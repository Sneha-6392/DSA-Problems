class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int distinctCount = 0;
        long lastChosenValue = Long.MIN_VALUE / 2; 
        for (int x : nums) {
            long requiredValue = Math.max(lastChosenValue + 1, (long)x - k);
            if (requiredValue <= (long)x + k) {
                lastChosenValue = requiredValue;
                distinctCount++;
            }
        }
        return distinctCount;
    }
}