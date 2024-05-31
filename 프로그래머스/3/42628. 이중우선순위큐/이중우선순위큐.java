import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        //최대 힙, 최소 힙 선언
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (String operation : operations) {
            String[] op = operation.split(" ");
            int num = Integer.parseInt(op[1]);
            
            //커맨드가 I이면 큐에 삽입
            if (op[0].equals("I")) {
                max.add(num);
                min.add(num);
            } else { //커맨드가 D이고
                //숫자가 1이면 최대값 삭제
                if (op[1].equals("1")) {
                    if (!max.isEmpty()) {
                        int n = max.poll();
                        min.remove(n);
                    }
                } else { //숫자가 -1이면 최소값 삭제
                    if (!min.isEmpty()) {
                        int n = min.poll();
                        max.remove(n);
                    }
                }
            }
        }
        
        //큐가 비어있으면 0,0 출력
        if(min.isEmpty() || max.isEmpty()){
            return new int[] {0,0};
        }

        answer[0] = max.poll();
        answer[1] = min.poll();

        return answer;
    }
}