import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        int N = 0;
        int idx = -1;
        int now = 0;
        while(N < jobs.length) {
            for(int[] job : jobs) {
                if(idx < job[0] && job[0] <= now) {
                    pq.add(job);
                }
            }
            
            if(!pq.isEmpty()) {
                int[] job = pq.poll(); 
                idx = now;
                now += job[1];
                answer += now - job[0];
                N++;
            }
            else now++;
            
        }
        return answer / jobs.length;
    }
}