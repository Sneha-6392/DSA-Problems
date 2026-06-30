class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i : asteroids) {
            while (!st.isEmpty() && i < 0 && st.peek() > 0) {
                if (st.peek() < -i) {
                    st.pop();
                    continue;
                }
                if (st.peek() == -i) {
                    st.pop();
                }
                i = 0;
            }
            if (i != 0) {
                st.push(i);
            }
        }
        int[] arr = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        return arr;
    }
}