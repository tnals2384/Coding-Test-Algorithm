import java.util.PriorityQueue;
import java.util.Comparator;
class Solution {
    public long solution(int N, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int work : works)
            queue.add(work);
        
        for(int i=0;i<N;i++) {
            int x = queue.poll();
            if( x == 0 )
                return 0;
            queue.add(x-1);
        }
        
        for(int i=0; i < works.length; i++) {
            answer+= Math.pow(queue.poll(), 2);
        }
        return answer;
    }
}