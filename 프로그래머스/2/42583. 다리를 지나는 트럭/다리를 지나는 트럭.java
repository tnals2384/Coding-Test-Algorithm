import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        Queue<Integer> queue = new LinkedList<>();
        
        int now = 0;
        
        for(int i=0;i<truck_weights.length;i++) {
            while(true) {
                if(queue.size() == bridge_length) {
                    now -= queue.poll();
                }
                else {    
                    if(now + truck_weights[i] <= weight) {
                        queue.add(truck_weights[i]);
                        now += truck_weights[i];
                        answer++;
                        break;
                    }
                    else {
                        queue.add(0);
                        answer++;
                    }
                }
            }

        }
        return answer;
    }
}