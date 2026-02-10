class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            HashSet<Integer> h1 = new HashSet<>();
            HashSet<Integer> h2 = new HashSet<>();
            for(int j = i; j < n; j++) {
                if(nums[j] % 2 == 0) {
                    h1.add(nums[j]);
                }
                else {
                    h2.add(nums[j]);
                }
                if(h1.size() == h2.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}