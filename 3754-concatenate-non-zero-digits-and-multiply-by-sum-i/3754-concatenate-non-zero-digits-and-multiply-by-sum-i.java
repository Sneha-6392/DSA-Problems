class Solution {
    public long sumAndMultiply(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;

        while (n != 0) {
            int rem = n % 10;
            if (rem != 0) {
                arr.add(rem);
                sum += rem;
            }
            n /= 10;
        }

        int num = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            num = num * 10 + arr.get(i);
        }

        return (long) num * sum;
    }
}