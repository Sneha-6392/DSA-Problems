class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int n = s.length();
        int i = 0;
        int j = k - 1;

        while (j < n) {
            reverse(i, j, str);
            i += (2 * k);
            j += (2 * k);
        }

        if (i < n) {
            reverse(i, n - 1, str);
        }

        return new String(str);
    }

    public void reverse(int i, int j, char[] str) {
        while (i <= j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;

            i++;
            j--;
        }
    }
}