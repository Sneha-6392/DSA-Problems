class Solution {
    public int maxScore(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int i = k - 1;
        int j = arr.length - 1;
        int max = sum;
        while (i >= 0) {
            sum -= arr[i];
            sum += arr[j];
            i--;
            j--;
            max = Math.max(max, sum);
        }
        return max;
    }
}