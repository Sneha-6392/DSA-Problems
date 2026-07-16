class Solution {
    public long gcdSum(int[] nums) {
        int[] prefix = new int[nums.length];
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            prefix[i] = gcd(maxValue, nums[i]);
        }

        Arrays.sort(prefix);

        int left = 0;
        int right = prefix.length - 1;
        long result = 0;

        while (left < right) {
            result += gcd(prefix[left], prefix[right]);
            left++;
            right--;
        }

        return result;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}