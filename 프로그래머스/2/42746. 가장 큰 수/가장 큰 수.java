import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        
        for(int i = 0; i< numbers.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, (o1,o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            
            return s2.compareTo(s1);
        });
        
        for(int i=0;i<nums.length;i++)
            answer+= nums[i];
        
        if(answer.charAt(0)=='0')
            return "0";
        return answer;
    }
}