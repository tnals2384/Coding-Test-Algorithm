import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int x;
        int c;

        public Node(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int N, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[] start = new int[N + 1];
        Arrays.fill(start, Integer.MAX_VALUE);
        int[] end = new int[N + 1];
        Arrays.fill(end, Integer.MAX_VALUE);
        int[] mid = new int[N + 1];
        Arrays.fill(mid, Integer.MAX_VALUE);

        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


        dijkstra(1, start);
        dijkstra(N, end);
        dijkstra(v1, mid);

        if (start[v1] == Integer.MAX_VALUE || end[v2] == Integer.MAX_VALUE || mid[v2] == Integer.MAX_VALUE || start[v2] == Integer.MAX_VALUE || end[v1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            int min = Math.min(start[v1] + end[v2], start[v2] + end[v1]);
            System.out.println(min + mid[v2]);
        }
    }

    static void dijkstra(int s, int[] cost) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        pq.add(new Node(s, 0));

        cost[s] = 0;
        visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.x]) continue;

            visited[now.x] = true;

            for (Node n : graph[now.x]) {
                if (visited[n.x]) continue;
                if (cost[n.x] > cost[now.x] + n.c) {
                    cost[n.x] = cost[now.x] + n.c;
                    pq.add(new Node(n.x, cost[n.x]));
                }
            }
        }
    }
}
