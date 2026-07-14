class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        double[] ans = new double[nums.length - k + 1];
        int idx = 0;
        ans[idx++] = median(list, k);
        for (int i = k; i < nums.length; i++) {
            int out = nums[i - k];
            int remIdx = Collections.binarySearch(list, out);
            list.remove(remIdx);
            int in = nums[i];
            int inIdx = Collections.binarySearch(list, in);
            if (inIdx < 0) {
                inIdx = -(inIdx + 1);
            }
            list.add(inIdx, in);
            ans[idx++] = median(list, k);
        }
        return ans;
    }
    public double median(ArrayList<Integer> list, int k) {
        if (k % 2 == 1) {
            return list.get(k / 2);
        }
        return ((double) list.get(k / 2 - 1) + (double) list.get(k / 2)) / 2.0;
    }
}