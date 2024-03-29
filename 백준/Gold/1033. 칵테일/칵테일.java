import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] A;
    static long[] D;
    static boolean[] visited;

    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); //총 수의 개수

        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Node>();
        }
        visited = new boolean[N];
        D = new long[N];

        long lcm = 1; //비율들의 최대 공배수

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, p, q));
            A[b].add(new Node(a, q, p));
            lcm *= (p * q) / gcd(p, q); //두수의 최대 공배수를 다 곱하면 모든 수의 최대 공배수
        }

        D[0] = lcm;
        dfs(0);
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        for (int i = 0; i < N; i++)
            bw.write(D[i] / mgcd + " ");

        bw.flush();
        bw.close();
    }

    public static void dfs(int start) {

        visited[start] = true;
        for (Node node : A[start]) {
            int next = node.b;
            if (!visited[next]) {
                D[next] = D[start] * node.q / node.p;
                dfs(next);
            }
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else return gcd(b, a % b);

    }
}
