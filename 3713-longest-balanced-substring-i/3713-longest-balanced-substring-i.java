class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        int[] arr = new int[26];
        for(int i = 0; i < n; i++) {
            Arrays.fill(arr, 0);
            for(int j = i; j < n; j++) {
                boolean flag = true;
                int c = s.charAt(j) - 'a';
                arr[c]++;
                for(int k : arr) {
                    if(k > 0 && k != arr[c]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}