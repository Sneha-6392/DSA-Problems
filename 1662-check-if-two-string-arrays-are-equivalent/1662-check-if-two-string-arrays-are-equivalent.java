class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = "";
        String str2 = "";
        for(String i : word1){
            str1 += i;
        }
        for(String i : word2){
            str2 += i;
        }
        return str1.equals(str2);
    }
}
        