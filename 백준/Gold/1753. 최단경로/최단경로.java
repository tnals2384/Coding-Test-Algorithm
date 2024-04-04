import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int x;
        int w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Node> [] A = new ArrayList[V+1];
        int[] answer = new int[V+1];
        boolean[] visited = new boolean[V+1];

        //배열 초기화
        for(int i=1;i<=V;i++) {
            A[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }
        //시작점 설정
        int K = Integer.parseInt(br.readLine());
        answer[K] = 0;

        //인접리스트 초기화
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[u].add(new Node(v,w));
        }

        //자동으로 거리가 최소인 노드를 선택하도록 priorityqueue 사용
        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt((Node node) -> node.w)
        );
        queue.add(new Node(K,0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(visited[now.x]) continue;
            
            visited[now.x]= true;
            for(Node n: A[now.x]) {
                if(answer[n.x] > answer[now.x]+n.w) {
                    answer[n.x] = answer[now.x]+n.w;
                    queue.add(new Node(n.x, answer[n.x]));
                }
            }
        }

        for(int i=1;i<=V;i++) {
            if(visited[i])
                System.out.println(answer[i]);
            else System.out.println("INF");
        }

    }
}
