class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        int[] start = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            }
            else{
                inc[i] = 1;
            }
        }
        start[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                start[i] = start[i + 1] + 1;
            }
            else {
                start[i] = 1;
            }
        }
        int k = 0;
        for (int i = 0; i < n - 1; i++) {
            k = Math.max(k, Math.min(inc[i], start[i + 1]));
        }
        return k;
    }
}