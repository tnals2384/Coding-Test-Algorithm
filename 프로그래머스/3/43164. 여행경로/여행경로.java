import java.util.*;
class Solution {
    ArrayList<String> answer;
    Queue<String> queue;
    int n;
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        queue = new PriorityQueue<>();
        visited = new boolean[n+1];
        
        dfs("ICN","ICN", 0, tickets);
        return queue.poll().split(" ");
    }
    
    public void dfs(String s, String route, int depth, String[][] tickets) {
        if(depth==n) {
            queue.add(route);
            return;
        }
        for(int i=0;i<n;i++) {
            if(!visited[i] && s.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], route+" "+ tickets[i][1],depth+1, tickets);
                visited[i] =false;
            }
        }
     
    }
}