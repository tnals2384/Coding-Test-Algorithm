import java.util.*;
class Solution {
    
    class Node {
        int x;
        int c;
        
        public Node(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
 
        //인접 리스트 활용
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++)
            graph[i] = new ArrayList<>();
        
        int[] time = new int[N+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        
        time[1] = 0;
        
        for(int[] r : road) {
            graph[r[0]].add(new Node(r[1],r[2]));
            graph[r[1]].add(new Node(r[0],r[2]));
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o1.c - o2.c);
        boolean[] visited = new boolean[N+1];
        queue.add(new Node(1,0));
        
        //탐색 시작
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(visited[now.x]) continue;
            visited[now.x] = true;
            
            for(Node n : graph[now.x]) {
                if(visited[n.x]) continue;
                if(time[n.x] > time[now.x] + n.c)
                    time[n.x] = time[now.x] + n.c;
                
                queue.add(new Node(n.x, time[n.x]));
            }
        }
        
        for(int i=0;i<=N;i++) {
            if(time[i] <= K) answer++;
        }
        return answer;
    }
}