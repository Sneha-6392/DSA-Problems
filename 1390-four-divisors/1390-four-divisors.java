class Solution {
    public int sumFourDivisors(int[] nums) {
       int sum = 0;
       int i = 0;
       while (i != nums.length) {
        int currSum = nums[i] + 1;
        int cnt = 2;
        for (int j = 2; j <= Math.sqrt(nums[i]); j++) {
            if (nums[i] % j == 0) {
                currSum += j;
                cnt++;
                if (j != (nums[i] / j)) {
                    currSum += (nums[i] / j);
                    cnt++;
                }
            }
        }
        if (cnt == 4) {
            sum += currSum;
        }
        i++;
       } 
       return sum;
    }
}