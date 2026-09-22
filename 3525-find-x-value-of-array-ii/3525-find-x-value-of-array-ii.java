class Solution {
    private static class Node {
        int prod;
        int[] cnt;

        Node() {
            prod = 1;
            cnt = new int[5];
        }
    }

    private int k;
    private Node[] tree;

    private Node merge(Node left, Node right) {
        Node res = new Node();

        res.prod = (left.prod * right.prod) % k;

        for (int i = 0; i < k; i++) {
            res.cnt[i] = left.cnt[i];
        }

        for (int i = 0; i < k; i++) {
            int rem = (left.prod * i) % k;
            res.cnt[rem] += right.cnt[i];
        }

        return res;
    }

    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            int rem = nums[start] % k;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }

        int mid = start + (end - start) / 2;

        build(nums, node * 2, start, mid);
        build(nums, node * 2 + 1, mid + 1, end);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            int rem = value % k;

            tree[node].prod = rem;

            for (int i = 0; i < k; i++) {
                tree[node].cnt[i] = 0;
            }

            tree[node].cnt[rem] = 1;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return new Node();
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        Node leftNode = query(node * 2, start, mid, left, right);
        Node rightNode = query(node * 2 + 1, mid + 1, end, left, right);

        return merge(leftNode, rightNode);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }

        build(nums, 1, 0, n - 1);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node result = query(1, 0, n - 1, start, n - 1);

            answer[i] = result.cnt[x];
        }

        return answer;
    }
}