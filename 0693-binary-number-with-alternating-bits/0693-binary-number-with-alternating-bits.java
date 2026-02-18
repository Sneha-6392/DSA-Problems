class Solution {
    public boolean hasAlternatingBits(int n) {
        String bin = "";
        while(n > 0) {
            bin = (n % 2) + bin;
            n /= 2;
        }
        boolean flag = true;
        char[] arr = bin.toCharArray();
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}