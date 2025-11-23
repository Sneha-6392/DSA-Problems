import java.util.*;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) rem1.add(num);
            if (num % 3 == 2) rem2.add(num);
        }
        Collections.sort(rem1);
        Collections.sort(rem2);
        if (sum % 3 == 0) return sum;
        if (sum % 3 == 1) {
            int remove1 = Integer.MAX_VALUE;
            int remove2 = Integer.MAX_VALUE;
            if (rem1.size() >= 1) remove1 = rem1.get(0);
            if (rem2.size() >= 2) remove2 = rem2.get(0) + rem2.get(1);   
            int minRemove = Math.min(remove1, remove2);
            if (minRemove == Integer.MAX_VALUE) return 0;
            return sum - minRemove;
        }
        int remove1 = Integer.MAX_VALUE;
        int remove2 = Integer.MAX_VALUE;        
        if (rem2.size() >= 1) remove1 = rem2.get(0);
        if (rem1.size() >= 2) remove2 = rem1.get(0) + rem1.get(1);
        int minRemove = Math.min(remove1, remove2);
        if (minRemove == Integer.MAX_VALUE) return 0;
        
        return sum - minRemove;
    }
}
