import java.util.*;
class Solution {
    public class Feat {
        int prog;
        int speed;
        
        public Feat(int prog,int speed) {
            this.prog = prog;
            this.speed = speed;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer =new ArrayList<>();
        
        Queue<Feat> queue = new LinkedList<>();
        for(int i=0;i<progresses.length;i++)
            queue.add(new Feat(progresses[i],speeds[i]));
        
        while(!queue.isEmpty()) {
            Feat now = queue.poll();
            int count = 1;
            int n=1;
            while(now.prog + now.speed * n < 100) {
                n++;
            }
            
            while(!queue.isEmpty()) {
                if(queue.peek().prog + queue.peek().speed*n < 100) 
                    break;
                queue.poll();
                count++;
                 
            }
            
            answer.add(count);
            
            
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}