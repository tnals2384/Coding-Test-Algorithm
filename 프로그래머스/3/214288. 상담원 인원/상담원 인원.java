import java.util.*;

class Solution {
    public class Time {
        int start;
        int end;
        
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    int[][] waiting;
    ArrayList<Time>[] list;
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        waiting = new int[k+1][n+1];
        list = new ArrayList [k+1];
        
        for(int i=1;i<=k;i++) 
            list[i] = new ArrayList<>();
        
        for(int[] req : reqs) {
            list[req[2]].add(new Time(req[0], req[0] + req[1]));
        }
        
        //상담사가 1명일 때 ~ n-k+1명일 때를 k별로 다 구해둠
        for(int i = 1; i <= k; i++) {
            if(list[k].size()==0) continue;
            
            for(int j = 1; j <= n-k+1; j++) {
                int waitingTime = getWaitingTime(list[i], j);
                waiting[i][j] = waitingTime;
            }
        }
        
        //상담사 한명씩 배치
        int[] mento = new int[k+1];
        for(int i = 1; i <= k; i++) {
            mento[i] = 1;
        }
        
        //멘토 수가 증가했을 때 웨이팅시간이 가장많이 감소되는 k에 + 1
        int remain = n-k;
        while(remain-- > 0)  {
            int max = 0;
            int idx = 0;
            for(int i=1; i<=k;i++) {
                int waitingTime = waiting[i][mento[i]];
                int nextWaitingTime = waiting[i][mento[i]+1];
                
                int reduceTime = Math.abs(waitingTime - nextWaitingTime);
                
                if(reduceTime >= max) {
                    max = reduceTime;
                    idx = i;
                }
            }
            
            if(max==0) break;
            mento[idx]++;
        }
        
        for(int i = 1; i <= k; i++) {
            answer += waiting[i][mento[i]];
        }
        
        return answer;
    }
    

    
    public int getWaitingTime(List<Time> time, int j) {
        int waitingTime = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Time t: time) {
            if(pq.isEmpty() || pq.size() < j) {
                pq.add(t.end);
            }
            else {
                int now = pq.poll();
                
                if(now > t.start) {
                    waitingTime += now - t.start;
                    pq.add(now - t.start + t.end);
                }
                else {
                    pq.add(t.end);
                }
            }
        }
        
        return waitingTime;
    }
}