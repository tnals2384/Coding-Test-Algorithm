import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int size = n;
        
        //삭제되는 행 번호만 스택에 저장
        for(String c : cmd) {
            char key = c.charAt(0);
            switch(key) {
                case('U') :
                    k -= Integer.parseInt(c.substring(2));
                    break;
                    
                case('D') :
                    k += Integer.parseInt(c.substring(2));
                    break;
                    
                case('C'):
                    stack.push(k);
                    size-=1;
                    if(size == k) k--;
                    break;
                    
                case('Z'):
                    if(stack.pop() <= k) k++;
                    size+=1;
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < size; i++) {
            sb.append('O');
        }
        while(!stack.isEmpty()) {
            int i = stack.pop();
            sb.insert(i, 'X');
        }

        return sb.toString();
    }
}