import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long s = 0;
        long e = times[times.length-1]*(long) n;
        
        while(s <= e) {
            long mid = (s+e)/2;
            long people = 0;
            
            for(long time: times) 
                people += mid / time;
            
            if(n > people) 
                s = mid + 1;
            else {
                answer = mid;
                e = mid - 1;
            }
            
        }
        return answer;
    }
    
}