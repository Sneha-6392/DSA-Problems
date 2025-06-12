class Solution {
    public int reverse(int x) {
        long rev=0;
        while(x!=0){
            long r=x%10;
            rev=(rev*10)+r;
            x/=10;
        }
        if(rev<Integer.MIN_VALUE || rev>Integer.MAX_VALUE){
            return 0;
        }
        else{
            return (int)rev;
        }
    }
}