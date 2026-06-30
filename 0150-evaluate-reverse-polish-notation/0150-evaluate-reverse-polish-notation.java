class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String i : tokens) {
            if (!i.equals("+") && !i.equals("-") && !i.equals("*") && !i.equals("/")) {
                st.push(Integer.parseInt(i));
            }
            else if (i.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b + a);
            }
            else if (i.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }
            else if (i.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b * a);
            }
            else {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            }
        }
        return st.pop();
    }
}