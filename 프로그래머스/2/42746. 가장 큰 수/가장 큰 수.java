import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        String answer = "";
        for(int i=0;i<str.length;i++)
            answer += str[i];
        
        
        if(answer.charAt(0)=='0') answer = "0";
        return answer;
    }
}