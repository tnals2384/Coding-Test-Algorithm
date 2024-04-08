import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int[] unionFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1<=V<=10000
        int V = Integer.parseInt(st.nextToken());
        //1<=E<=100000
        int E = Integer.parseInt(st.nextToken());

        //가중치가 작은 순서대로 진행
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.w));
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            queue.add(new Edge(A, B, C));
        }

        unionFind = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            unionFind[i] = i;
        }

        int result = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            //사이클이 생기지 않는지 확인하며 진행
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.w;
            }
        }

        System.out.println(result);

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            unionFind[b] = a;
    }

    public static int find(int x) {
        if (x == unionFind[x])
            return x;
        else return unionFind[x] = find(unionFind[x]);
    }
}
