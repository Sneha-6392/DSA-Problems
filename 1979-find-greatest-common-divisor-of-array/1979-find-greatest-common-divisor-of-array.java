class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int smallest = nums[0];
        int largest = nums[nums.length - 1];
        return gcd(smallest, largest);
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b; 
            b = a % b;
            a = temp;
        }
        return a;
    }
}