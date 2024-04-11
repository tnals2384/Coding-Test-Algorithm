import java.util.*;
import java.util.stream.*;

class Solution {
      public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
	
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
 
        return true;
    }
    
    Set<Integer> nums;
    boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;

        nums = new HashSet<>();
        dfs(numbers,"", 0);
        
        for(Integer num : nums) {
            if(isPrime(num))
                answer++;
        }
        return answer;
    }
    
    public void dfs(String numbers, String s, int depth) {
        if(depth > numbers.length())
            return;
        
        for(int i=0;i<numbers.length();i++) {
            if(!visited[i]) {
                visited[i] = true;
                nums.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
}