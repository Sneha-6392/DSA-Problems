class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
       
       int n = nums.length;
       int[] result = new int[n-k+1];

       Map<Integer,Integer> hmap = new HashMap<>();
       for(int i = 0 ; i < k ; i++){
            hmap.put(nums[i], hmap.getOrDefault(nums[i],0) + 1);
       }

       TreeSet<int[]> tset = new TreeSet<>( (a,b) -> {
            if(a[0] != b[0])
                return b[0] - a[0]; 
            return b[1] - a[1]; 
        });

       for(Map.Entry<Integer,Integer>  entry : hmap.entrySet()){
            tset.add(new int[]{entry.getValue() , entry.getKey()});
       }

       result[0] = topXSum(tset, x);

      for(int i = 1 ; i < n - k + 1 ; i++){
         int firstEle = nums[i-1];
         int lastEle = nums[i+k-1];

         int oldFreq = hmap.get(firstEle);
         tset.remove(new int[]{oldFreq, firstEle});


         if(oldFreq == 1){
            hmap.remove(firstEle);
         } else {

            tset.add(new int[]{oldFreq-1, firstEle});
            hmap.put(firstEle, oldFreq-1);
         }

         int lastEleFreq = hmap.getOrDefault(lastEle, 0);
         if(lastEleFreq > 0) {
            tset.remove(new int[]{lastEleFreq, lastEle});
         }
         hmap.put(lastEle, lastEleFreq+1);
         tset.add(new int[]{lastEleFreq+1, lastEle});

        result[i] = topXSum(tset, x);
      }

      return result;
    }

    private int topXSum(TreeSet<int[]> tset, int x){
        int cnt = 0;
        int sum = 0;
        for(int[] pair : tset){
            if(cnt >= x) break;
            sum += (pair[0] * pair[1]);
            cnt++;
        }
        return sum;
    }
}