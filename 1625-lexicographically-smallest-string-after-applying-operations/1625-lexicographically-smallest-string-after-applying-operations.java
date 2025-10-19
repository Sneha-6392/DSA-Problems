class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String result = s;
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (seen.contains(curr)) continue;
            seen.add(curr);
            if (curr.compareTo(result) < 0) result = curr;
            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                int newDigit = ((chars[i] - '0') + a) % 10;
                chars[i] = (char) ('0' + newDigit);
            }
            String addOp = new String(chars);
            int n = curr.length();
            String rotOp = curr.substring(n - b) + curr.substring(0, n - b);
            queue.offer(addOp);
            queue.offer(rotOp);
        }

        return result;
    }
}