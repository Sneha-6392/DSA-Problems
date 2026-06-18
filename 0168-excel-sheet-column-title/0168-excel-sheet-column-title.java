class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n -= 1;
            int rem = (n % 26) + 65;
            n /= 26;
            sb.append((char)rem);
        }
        return sb.reverse().toString();
    }
}