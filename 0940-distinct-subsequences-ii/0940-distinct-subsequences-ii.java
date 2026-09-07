class Solution {
    public int distinctSubseqII(String s) {
        long MOD=1000000007;
        long dp=1;
        long[] last=new long[26];
        Arrays.fill(last,0);
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            long newDp=(2*dp%MOD-last[c]+MOD)%MOD;
            last[c]=dp;
            dp=newDp;
        }
        return (int)((dp-1+MOD)%MOD);
    }
}