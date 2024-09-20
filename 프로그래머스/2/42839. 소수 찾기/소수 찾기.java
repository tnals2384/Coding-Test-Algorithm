import java.util.*;
class Solution {
    boolean[] visited;
    int count;
    ArrayList<Integer> list;
    
    public int solution(String numbers) {
        list = new ArrayList<>();
        String[] num = numbers.split("");
        visited = new boolean[num.length];
        dfs(num, "");
        
        return count;
    }
    
    public void dfs(String[] num, String str) {
 
        for(int i = 0 ; i < num.length ; i++) {
            if(visited[i]) continue;
            
            String s = str + num[i];
            int n = Integer.parseInt(s);
           
            if(!list.contains(n)) {
                list.add(n);

                if(isPrime(n)) count++;
            }
            
            visited[i] = true;
            dfs(num, s);
            visited[i] = false;
        }
    } 
    public boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}