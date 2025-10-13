class Solution {
    public boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        if(words.length == 0) return result;
        result.add(words[0]); 
        for(int i = 1; i < words.length; i++){
            String last = result.get(result.size() - 1);
            if(!isAnagram(last, words[i])){
                result.add(words[i]);
            }
        }
        return result;
    }
}