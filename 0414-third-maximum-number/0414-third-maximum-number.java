class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        if (arr.size() <= 2) {
            return arr.get(arr.size() - 1);
        }
        return arr.get(arr.size() - 3);
    }
}