import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int now = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);
        for(int[] job : jobs) {
            queue.add(job);
        }

        int total = 0;
        int complete = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        while(complete < jobs.length) {
            while(!queue.isEmpty() && queue.peek()[0] <= now) {
                pq.add(queue.poll());
            }

            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                now += job[1]; //수행시간
                total += now - job[0];
                complete++;
            }
            else now++;

        }
        return total/jobs.length;
    }
}