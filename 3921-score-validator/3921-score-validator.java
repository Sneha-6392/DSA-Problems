class Solution {
    public int[] scoreValidator(String[] events) {
        int score=0;
        int wickets=0;
        int i=0;
        while(i<events.length && wickets<10)
        {
            if(events[i].equals("W"))
            {
                wickets++;
            }
            else if(events[i].equals("WD") || events[i].equals("NB"))
            {
                score++;
            }
            else{
                score+=Integer.parseInt(events[i]);
            }
            i++;
        }
        return new int[]{score,wickets};
    }
}