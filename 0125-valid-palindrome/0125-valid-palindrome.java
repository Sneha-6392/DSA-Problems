class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String t = "";
        for(int i=s.length()-1; i>=0; i--){
            t+=s.charAt(i);
        }
        if(s.equals(t)){
            return true;
        }
        return false;
    }
}