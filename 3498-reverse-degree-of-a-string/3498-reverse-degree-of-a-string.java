class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int i = 1;
        for (char ch : s.toCharArray()) {
            int idx = (ch - 'a');
            int revidx = 26 - idx;
            sum = sum + (i * revidx);
            i++;
        }
        return sum;
    }
}