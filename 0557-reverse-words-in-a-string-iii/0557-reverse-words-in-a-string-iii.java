class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            String rev = str[i];
            str[i] = reverse(rev);
        }

        return String.join(" ", str);
    }
    public String reverse(String rev) {
        char[] ch = rev.toCharArray();
        int i = 0;
        int j = ch.length - 1;

        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }

        return new String(ch);
    }
}