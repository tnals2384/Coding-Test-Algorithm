import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<Node>[] A = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            A[s].add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        cost[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.c));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited[now.x]) {
                visited[now.x] = true;

                for (Node n : A[now.x]) {
                    if (!visited[n.x] && cost[n.x] > cost[now.x] + n.c) {
                        cost[n.x] = cost[now.x] + n.c;
                        queue.add(new Node(n.x, cost[n.x]));
                    }
                }
            }
        }

        System.out.println(cost[end]);
    }
}
