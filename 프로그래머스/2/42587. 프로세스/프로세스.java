import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
        
        for(int p: priorities) {
            pq.add(p);
        }
        while(!pq.isEmpty()) {
            for(int i=0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    pq.poll();
                    if(location == i)
                        return answer;
                    else answer++;
                }
            }
        }
        return answer;
    }
}