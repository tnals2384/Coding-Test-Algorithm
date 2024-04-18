import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> queue = new PriorityQueue<>();
        for(int n: scoville)
            queue.add(n);
        
        while(true) {
            int min = queue.poll();
            if(min >= K) 
                break;
            if(queue.size()==0)
                return -1;
            queue.add(min + (queue.poll()*2));
            answer++;
        }
        
        return answer;
    }
}