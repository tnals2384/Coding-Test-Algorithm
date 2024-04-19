import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //작업 시작 가능한 것들 중 소요시간이 짧은 순으로 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] o) -> o[1]));
        
        int now = 0;
        int count = 0;
        int start = -1;
        
        while(count < jobs.length) {
           
            //요청 시간이 전 작업 시작시간보다 크고, 현재 시간보다 작거나 같으면 시작 가능한 작업
            for(int[] job : jobs) {
                if(start < job[0] && now >= job[0]) {
                    queue.add(job);
                }
            }
            
            //시작 가능한 작업이 있으면 시작해주고 시간 더하기
            if(!queue.isEmpty()) {
                int[] job = queue.poll();
                start = now;
                now += job[1];
                answer += now - job[0];
                count++;
            }
            //시작 가능한 작업이 없으면 현재 시간을 올려줌
            else now++;
        }
        
        return answer/ (jobs.length) ;
    }
}