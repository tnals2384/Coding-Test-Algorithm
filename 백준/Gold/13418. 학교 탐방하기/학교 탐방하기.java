import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static class Edge {
        int a;
        int b;
        int c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;

        }
    }

    public static int[] parent;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }
        edges.sort((o1, o2) -> o2.c - o1.c);
        int min = unionFind(edges);
        edges.sort((o1, o2) -> o1.c - o2.c);
        int max = unionFind(edges);

        System.out.println(max - min);
    }

    public static int unionFind(ArrayList<Edge> edges) {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
      
        int count = 0;

        for (Edge e : edges) {
            if (find(e.a) != find(e.b)) {
                if (e.c == 0) {
                    count++;
                }
                union(e.a, e.b);
            }
        }

        return count*count;
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y)
            parent[y] = x;
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }
}
