import java.util.*;

class Solution {
    ArrayList<Node>[] graph;
    public class Node {
        int x;
        int w;
        
        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
    //다익스트라
    public int solution(int n, int s, int a, int b, int[][] fares) {
         int answer = Integer.MAX_VALUE;
         
         graph = new ArrayList[n+1];
         for(int i=1;i<=n;i++) {
             graph[i] = new ArrayList<>();
         }
         
         for(int[] fare: fares) {
             graph[fare[0]].add(new Node(fare[1],fare[2]));
             graph[fare[1]].add(new Node(fare[0],fare[2]));
         }
        
        int[] stok = dijkstra(s,n);
        int[] atok = dijkstra(a,n);
        int[] btok = dijkstra(b,n);
        
        for(int i=1;i<=n;i++) {
            answer= Math.min(answer, stok[i]+atok[i]+btok[i]);
        }
        
         return answer;
    }
    
   public int[] dijkstra(int start, int n) {
        boolean[] visited = new boolean[n+1];
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
       
        cost[start]=0;
       
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o1.w-o2.w);
       
        queue.add(new Node(start, 0));
       
        while(!queue.isEmpty()) {
           Node now = queue.poll();
           
           if(!visited[now.x]) {
               visited[now.x] = true;
               
               for(Node node : graph[now.x]) {
                   if(!visited[node.x] && cost[node.x] > cost[now.x] + node.w) {
                       cost[node.x] = cost[now.x] + node.w;
                       queue.add(new Node(node.x, cost[node.x]));
                   }
               }
           }
       }
       
       return cost;
   }
    
    /* 플로이드 워셜
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        long[][] node = new long[n+1][n+1];
        
        for(int i=1;i<=n;i++) {
            Arrays.fill(node[i], Integer.MAX_VALUE);
            node[i][i]=0;
        }
        
        for(int[] fare : fares) {
            node[fare[0]][fare[1]] = fare[2];
            node[fare[1]][fare[0]] = fare[2];
        }
        
        
        for(int k=1; k <= n; k++) {
            for(int i = 1;i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    node[i][j] = Math.min(node[i][j], node[i][k] + node[k][j]);
                }
            }
        }
        
        for(int k =1; k<=n;k++) {
            answer = (int) Math.min(answer, node[s][k] + node[k][a] + node[k][b]);
        }
        return answer;
    }
    */
}