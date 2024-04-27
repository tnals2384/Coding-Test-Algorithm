import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] visited = new int[n+1];
        ArrayList<Integer>[] A = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            A[i] = new ArrayList<Integer>();
        
        for(int[] e : edge) {
            A[e[0]].add(e[1]);
            A[e[1]].add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        visited[1]=1;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int i : A[now]) {
                if(visited[i]!=0)
                    continue;
                queue.add(i);
                visited[i] = visited[now]+1;
            }
            
        }
        
        Arrays.sort(visited);
        int max = visited[n];
        for(int i=n;i>=0;i--) {
            if(visited[i]==max)
                answer++;
            else break;
        }
        return answer;
    }
}