class Solution {
    public int heightChecker(int[] ht) {
        int n = ht.length;
        int[] exp = new int[n];
        for (int i = 0; i < n; i++) {
            exp[i] = ht[i];
        }

        Arrays.sort(exp);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (ht[i] != exp[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}