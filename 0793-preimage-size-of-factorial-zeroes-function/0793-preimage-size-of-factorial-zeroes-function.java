class Solution {
    public int preimageSizeFZF(int k) {
        long low = 0;
        long high = 5L * (k + 1);
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long zeros = tz(mid);
            if (zeros < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (tz(low) == k)
            return 5;
        return 0;
    }

    public long tz(long n) {
        long count = 0;
        while (n != 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}