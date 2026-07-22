class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        helper(s, 0, n - 1);
    }
    public void helper(char[] arr, int left, int right) {
        if (left >= right)
            return;
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        helper(arr, left + 1, right - 1);
    }
}