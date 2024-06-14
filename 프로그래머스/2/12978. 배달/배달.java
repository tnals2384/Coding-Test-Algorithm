import java.util.*;

class Solution {
    public class Node {
        int x;
        int w;
        
        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Node> [] graph = new ArrayList [N+1];
        for(int i=1;i<=N;i++) {
            graph[i]= new ArrayList<Node>();
        }
        
        for(int[] r : road) {
            graph[r[0]].add(new Node(r[1],r[2]));
            graph[r[1]].add(new Node(r[0],r[2]));
        }
        
        boolean[] visited = new boolean[N+1];
        //time
        int[] time = new int[N+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        
        time[1] = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
        queue.add(new Node(1,0));
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(visited[now.x]) continue;
            visited[now.x] = true;
            for(Node n: graph[now.x]) {
                time[n.x] = Math.min(time[n.x], time[now.x] + n.w);
                queue.add(new Node(n.x, time[n.x]));
            }
        }
        
        for(int i=1;i<=N;i++)
            if(time[i]<=K) answer++;
        return answer;
    }
}