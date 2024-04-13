import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer> [] tree;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        tree = new ArrayList[n+1];
        
        for(int i=0; i <= n; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        
        for(int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        
        for(int[] wire: wires) {
            visited = new boolean[n+1];
            
            tree[wire[0]].remove(Integer.valueOf(wire[1]));
            tree[wire[1]].remove(Integer.valueOf(wire[0]));
            
            int count = dfs(wire[0]);
            int diff = Math.abs(count- (n - count));
            answer = Math.min(answer, diff);
            
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        return answer;
    }
    
    
    public int dfs(int s) {
        visited[s] = true;
        int count=1;
        for(int now : tree[s]) {
            if (!visited[now])
                count += dfs(now);
        }
        
        return count;
    }
}