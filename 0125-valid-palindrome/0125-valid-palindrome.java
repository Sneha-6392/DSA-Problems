class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String t = "";
        for(int i=s.length()-1; i>=0; i--){
            t+=s.charAt(i);
        }
        if(s.equals(t)){
            return true;
        }
        System.out.println(s);
        System.out.println(t);
        return false;
    }
}