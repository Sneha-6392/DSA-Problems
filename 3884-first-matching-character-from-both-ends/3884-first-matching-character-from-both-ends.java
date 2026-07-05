class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        for(int i = 0 ; i<= n/2 ;i++){
            int idx = n-i-1;
            if(s.charAt(i) == s.charAt(idx)){
                return i;
            }
        }
        return -1;
    }
}