class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        ArrayList<Integer> arr = new ArrayList<>();
        int top = 0;
        int bottom = m.length - 1;
        int left = 0;
        int right = m[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                arr.add(m[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                arr.add(m[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    arr.add(m[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    arr.add(m[i][left]);
                }
                left++;
            }
        }
        return arr;
    }
}