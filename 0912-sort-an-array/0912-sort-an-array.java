class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int range = max - min + 1;
        int[] cnt = new int[range];

        for (int num : nums) {
            cnt[num - min]++;
        }

        for (int i = 1; i < range; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            ans[cnt[val - min] - 1] = val;
            cnt[val - min]--;
        }

        return ans;
    }
}