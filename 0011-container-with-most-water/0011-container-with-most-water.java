class Solution {
    public int maxArea(int[] h) {
        int l = 0; 
        int r = h.length - 1;
        int max = 0;
        while (l < r) {
            int area = (r - l) * Math.min(h[l], h[r]);
            max = Math.max(max, area);
            if (h[l] < h[r]) l++;
            else r--;
        }
        return max;
    }
}