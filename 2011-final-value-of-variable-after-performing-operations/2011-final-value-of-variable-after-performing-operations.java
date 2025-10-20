class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n = 0;
        for (String op : operations) {
            if (op.contains("++")) {
                n++;
            } else {
                n--;
            }
        }
        return n;
    }
}