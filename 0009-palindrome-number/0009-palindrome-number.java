class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        return s.equals(t);
    }
}