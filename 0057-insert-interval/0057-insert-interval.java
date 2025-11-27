class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int index = 0;

        while(index < n) {
            if(intervals[index][1] < newInterval[0]) {
                result.add(intervals[index]);
            }
            else if(intervals[index][0] > newInterval[1]) {
                break;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            }
            index++;
        }

        result.add(newInterval);
        while(index < n) { 
            result.add(intervals[index]);
            index++;
        }

        return result.toArray(new int[result.size()][]);
    }
}