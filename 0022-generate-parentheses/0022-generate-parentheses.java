class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        return generate(n,0,0,"",ans);
    }
    public List<String> generate(int n,int oc,int cc,String s,List<String>ans){
        if(oc==n && cc==n){
            ans.add(s);
        }
        if(oc<n){
            generate(n,oc+1,cc,s+'(',ans);
        }
        if(cc<n && cc<oc){
            generate(n,oc,cc+1,s+')',ans);
        }
        return ans;
    }
}