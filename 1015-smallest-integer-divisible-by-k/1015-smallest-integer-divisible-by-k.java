class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k==1){
            return 1;
        }
        if(k%2==0 || k%5==0){
            return -1;
        }
        long n =0;
        int l=0;
        while(true){
            n = (n * 10 + 1) % k;
            l++;

            if (n == 0) {
                return l;
        }
    }
}
}