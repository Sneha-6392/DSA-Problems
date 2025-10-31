class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
            if (freq.containsKey(i)) {
                freq.put(i, freq.getOrDefault(i, 0) + 1);
            }
            else {
                freq.put(i, 1);
            }
        }
        List<Integer> arr = new ArrayList<>();
        for (int i : set) {
            if (freq.get(i) == 2) {
                arr.add(i);
            }
        }
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;

    }
} 