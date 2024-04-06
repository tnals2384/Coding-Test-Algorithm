import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M + 1];
        long[] cost = new long[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, w);
        }

        //벨만 포드 알고리즘
        cost[1] = 0;
        for (int i = 1; i < N; i++) { //N보다 1작은 수만큼 반복
            for (int j = 0; j < M; j++) {
                //더 작은 최단 거리가 있을 때 업데이트
                Edge edge = edges[j];

                if (cost[edge.s] != Integer.MAX_VALUE
                        && cost[edge.e] > cost[edge.s] + edge.w) {
                    cost[edge.e] = cost[edge.s] + edge.w;
                }
            }
        }

        boolean cycle = false;

        for (int i = 0; i < M; i++) { //음수 사이클 확인
            Edge edge = edges[i];
            if (cost[edge.s] != Integer.MAX_VALUE
                    && cost[edge.e] > cost[edge.s] + edge.w) {
                cycle = true;
            }
        }

        if (!cycle) {
            for (int i = 2; i <= N; i++) {
                if (cost[i] == Integer.MAX_VALUE)
                    bw.write(-1 + "\n");
                else bw.write(cost[i]+ "\n");
            }
        } else bw.write(-1+ "\n");

        bw.flush();
    }
}
