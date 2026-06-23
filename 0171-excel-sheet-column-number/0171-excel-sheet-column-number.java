class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int val = ch - 'A' + 1;
            ans = ans * 26 + val;
        }
        return ans;
    }
}