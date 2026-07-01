class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : bulbs) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                arr.add(entry.getKey());
            }
        }
        Collections.sort(arr);
        return arr;
   }
}