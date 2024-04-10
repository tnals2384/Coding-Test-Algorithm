import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = Arrays.stream(numbers).mapToObj(Integer::toString).toArray(String[]::new);
        
        Arrays.sort(nums,(o1,o2) -> {
            String st1 = o1 + o2;
            String st2 = o2 + o1;
            
            return st2.compareTo(st1); //내림차순 
        });
        
        for(String num : nums)
            answer+=num;
        
        //0이 연속되는 경우 가장 큰 값은 0
        if(answer.charAt(0)=='0')
            return "0";
        
        return answer;
    }
}