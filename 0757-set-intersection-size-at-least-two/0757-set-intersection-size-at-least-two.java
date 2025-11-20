class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals ,(a,b)->a[1]==b[1]?b[0]-a[0]:a[1]-b[1]);
        List<Integer> nums= new ArrayList<>();
        int last =-1;
        int slast=-1;
        for(int[] i:intervals){
            int start= i[0];
            int end= i[1];
            boolean hasLast = (last >= start && last <= end);
            boolean hasSecondLast = (slast >= start && slast <= end);
            if (hasLast && hasSecondLast) {
                continue;
            }

            if (hasLast) {
                int newPoint = end;
                nums.add(newPoint);

                slast = last;
                last = newPoint;
            } else {
                int p1 = end - 1;
                int p2 = end;
                nums.add(p1);
                nums.add(p2);
                slast = p1;
                last = p2;
            }
        }
        return nums.size();
        
    }
}