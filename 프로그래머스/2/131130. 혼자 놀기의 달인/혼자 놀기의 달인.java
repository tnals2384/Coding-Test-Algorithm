import java.util.*;
class Solution {

    public boolean[] visited;
    public PriorityQueue<Integer> pq;
    
    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        pq = new PriorityQueue<>();
        for(int i = 0; i < cards.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                find(i, 1, cards);
            }
        }
        
        if(pq.size() == 1) return 0;
        
        return pq.poll() * pq.poll();
    }
    
    public void find(int start, int d, int[] cards) {
        int nextIdx = cards[start];
        if(visited[nextIdx-1]) {
            pq.add(-d);
            return;
        }
        
        visited[nextIdx-1] = true;
        find(nextIdx-1, d+1, cards);
    }
}