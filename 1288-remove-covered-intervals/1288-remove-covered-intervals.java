class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->  {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int cnt = 1;
        int maxLen = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] > maxLen) {
                cnt++;
                maxLen = intervals[i][1];
            }
        }
        return cnt;
    }
}