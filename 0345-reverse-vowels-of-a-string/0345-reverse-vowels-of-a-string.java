class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        
        HashSet<Character> set = new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            if (set.contains(ch[left]) && set.contains(ch[right])) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
            else if (!set.contains(ch[left]) && !set.contains(ch[right])) {
                left++;
                right--;
            }
            else if (!set.contains(ch[left])) {
                left++;
            }
            else {
                right--;
            }
        }
        return new String(ch);
    }
}