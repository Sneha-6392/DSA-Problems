// class Solution {
//     public String longestDupSubstring(String s) {
//         int n = s.length();
//         String[] suffix = new String[n];
//         Integer[] index = new Integer[n];

//         // suffix array
//         for (int i = 0; i < n; i++) {
//             suffix[i] = s.substring(i);
//             index[i] = i;
//         }

//         // sort index array
//         Arrays.sort(index, (a, b) -> suffix[a].compareTo(suffix[b]));

//         int[] lcp = new int[n];

//         for (int i = 1; i < n; i++) {
//             String s1 = suffix[index[i]];
//             String s2 = suffix[index[i - 1]];

//             int len = 0;

//             while (len < s1.length() && len < s2.length() && s1.charAt(len) == s2.charAt(len)) {
//                 len++;
//             }
//             lcp[i] = len;
//         }

//         int max = 0;
//         int pos = 0;

//         for (int i = 1; i < n; i++) {
//             if (lcp[i] > max) {
//                 max = lcp[i];
//                 pos = i;
//             }
//         }
//         if (max == 0) return "";

//         return s.substring(index[pos], index[pos] + max);
//     }
// }


import java.util.HashMap;

class Solution {
    public String longestDupSubstring(String s) {
        return binarySearch(s);
    }
    
    private String rollingHash(String str, int window) {
        long multiplier = 31;
        long mod = 1000000007;
        
        long hashedValue = 0;
        for (int i = 0; i < window; i++) {
            hashedValue = (hashedValue * multiplier + (str.charAt(i) - 'a' + 1)) % mod;
        }
        
        long power = 1;
        for (int i = 1; i < window; i++) {
            power = (power * multiplier) % mod;
        }
        
        HashMap<Long, Integer> map = new HashMap<>();
        hashedValue %= mod;
        map.put(hashedValue, 0);
        
        for (int i = 1; i + window <= str.length(); i++) {
            hashedValue -= ((str.charAt(i - 1) - 'a' + 1) * power);
            while (hashedValue < 0) {
                hashedValue += mod;
            }
            hashedValue %= mod;
            
            hashedValue *= 31;
            hashedValue %= mod;
            hashedValue += (str.charAt(i + window - 1) - 'a' + 1);
            hashedValue %= mod;
            
            if (map.containsKey(hashedValue)) {
                int start = map.get(hashedValue);
                String oldStr = str.substring(start, start + window);
                String newStr = str.substring(i, i + window);
                if (oldStr.equals(newStr)) {
                    return newStr;
                }
            }
            map.put(hashedValue, i);
        }
        return "";
    }
    
    private String binarySearch(String str) {
        int start = 1;
        int end = str.length() - 1;
        String result = "";
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            String temp = rollingHash(str, mid);
            if (!temp.isEmpty()) {
                result = temp;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}