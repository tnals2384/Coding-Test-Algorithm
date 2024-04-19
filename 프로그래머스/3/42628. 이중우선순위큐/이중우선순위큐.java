import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());  
        List<Integer> visited = new ArrayList<>();
        for(String operation: operations) {
            String[] st = operation.split(" ");
            String cmd = st[0];
            Integer num = Integer.parseInt(st[1]);
            if(cmd.equals("I")) {
                min.add(num);
                max.add(num);
            }
            else {
                if(num == -1) {
                    if(!min.isEmpty()) {
                        int n = min.poll();
                        max.remove(n);
                    }
                }
                else {
                    if(!max.isEmpty()) {
                        int n = max.poll();
                        min.remove(n);
                    }
                }
            }
        }
        if(min.isEmpty() || max.isEmpty()) {
            answer[0]=0;
            answer[1]=0;
            return answer;
        }
        
        answer[0] = max.poll();
        answer[1] = min.poll();
        
        
        return answer;
    }
}