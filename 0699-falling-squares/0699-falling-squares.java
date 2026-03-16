class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> intervals = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();

        for (int[] pos : positions) {
            int left = pos[0];
            int size = pos[1];
            int right = left + size;
            int maxHeight = 0;

            for (int[] interval : intervals) {
                int l = interval[0];
                int r = interval[1];
                int h = interval[2];

                if (right > l && left < r) {
                    maxHeight = Math.max(maxHeight, h);
                }
            }
            int currHeight = maxHeight + size;
            intervals.add(new int[] {left, right, currHeight});

            if (heights.isEmpty()) {
                heights.add(currHeight);
            }
            else {
                heights.add(Math.max(heights.get(heights.size() - 1), currHeight));
            }
        }
        return heights;
    }
}