import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
         int[] timetables = Arrays.stream(timetable)
                .mapToInt(time -> {
                    String[] hm = time.split(":");
                    return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
                })
                .sorted()
                .toArray();
        
        
        int[] bus = new int[n];
        bus[0] = 9*60;
        for(int i=1;i<n;i++) {
            bus[i] = bus[i-1]+t;
        }
        
        int idx = 0;
        int max = bus[n-1];
        int answer = bus[n-1];
        for(int busTime : bus) {
            int capacity = 0;
            while(capacity < m && idx < timetables.length && 
                        timetables[idx] <= busTime) {
                capacity++;
                idx++;
            }
            
            if(busTime == max) {
                if(capacity == m) 
                    answer = timetables[idx-1] - 1;
                else
                    answer = busTime;
                    
            }
        }
        return String.format("%02d:%02d", answer/60, answer%60);
    
    }
}
    

 