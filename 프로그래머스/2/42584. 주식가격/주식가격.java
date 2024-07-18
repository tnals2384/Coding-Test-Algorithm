import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        //1. answer를 초기화하기
        for(int i=0; i < prices.length; i++)
            answer[i] = prices.length-1-i;
    
        //2. stack에 index를 넣음
        for(int i = 0; i < prices.length; i++) {
            
            //3. 스택에 prices[i]보다 큰 수의 인덱스가 있는 동안 반복
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            //4. stack에 넣기
            stack.push(i);
        }
        
        return answer;
    }
}