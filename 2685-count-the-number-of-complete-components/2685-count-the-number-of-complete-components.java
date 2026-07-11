class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] ed: edges){
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }
      int count=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(bfs(i,vis,adj)){
                   count++;
                }
            }
        }
        return count;
    }
    private boolean bfs(int src,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> nodes=new ArrayList<>();
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(src);
        vis[src]=true;
        nodes.add(src);
        while(!q.isEmpty()){
            int n=q.poll();
            for(int ne : adj.get(n)){
                if(!vis[ne]){
                    nodes.add(ne);
                    vis[ne]=true;
                    q.offer(ne);
                }
            }
        }

        for(int i=0;i<nodes.size();i++){
            if(adj.get(nodes.get(i)).size()!=nodes.size()-1){
                return false;
            }
        }
        return true;
    }
}