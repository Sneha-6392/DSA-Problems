import java.util.*;

class Solution {
    static class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb)
                parent[pb] = pa;
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);

        for (int[] edge : connections) {
            dsu.union(edge[0], edge[1]);
        }
        Map<Integer, PriorityQueue<Integer>> grid = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            grid.computeIfAbsent(root, k -> new PriorityQueue<>()).add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (online[x]) {
                    ans.add(x);
                } else {
                    PriorityQueue<Integer> pq = grid.get(root);
                    int chosen = -1;
                    while (pq != null && !pq.isEmpty()) {
                        int top = pq.peek();
                        if (online[top]) {
                            chosen = top;
                            break;
                        } else pq.poll();
                    }
                    ans.add(chosen);
                }
            } else {
                if (online[x]) {
                    online[x] = false;
                }
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

}