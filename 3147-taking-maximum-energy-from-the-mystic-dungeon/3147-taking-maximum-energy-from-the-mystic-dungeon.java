class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = energy[i];
            if (i + k < n) {
                arr[i] += arr[i + k];
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}