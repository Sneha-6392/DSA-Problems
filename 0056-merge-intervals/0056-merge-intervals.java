class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0) return new int[0][0];

        List<int[]> merged=new ArrayList<>();
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));

        int[] curr=intervals[0];

        for(int i=1;i<intervals.length;i++){
            int[] next=intervals[i];

            if(next[0]<=curr[1]){
                curr[1]=Math.max(next[1],curr[1]);
            }

            else{
                merged.add(curr);
                curr=next;
            }
        }
        merged.add(curr);
        return merged.toArray(new int[merged.size()][]);
    }
}