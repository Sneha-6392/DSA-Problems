class Solution {      
    int ans = 100000;
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] i : roads) {
            int u = i[0];
            int v = i[1];
            int c = i[2];
            map.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, c});            // bi-directional so u to v and v to u
            map.computeIfAbsent(v, x -> new ArrayList<>()).add(new int[]{u, c});
        }
        boolean[] visited = new boolean[n + 1];
        dfs(1, map, visited);
        return ans;
    }
    public void dfs(int node, Map<Integer, List<int[]>> map, boolean[] visited) {
        visited[node] = true;
        for (int[] i : map.getOrDefault(node, new ArrayList<>())) {
            int adj = i[0];
            int c = i[1];
            ans = Math.min(ans, c);
            if (!visited[adj])
                dfs(adj, map, visited);
        }
    }
}