import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Edge {
        int s;
        int e;
        int c;

        public Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        //엣지배열에 추가하기
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, c);
        }

        //cost 배열
        long[] cost = new long[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[1] = 0;

        //dp로 반복적으로 최단 경로 갱신
        //첫번째는 출발점에서 한건선을 거쳐 도달할 수 있는 노드들 최단거리 갱신
        //두번재는 두간선을 거쳐 도달할 수 있는 노드들의 최단거리 갱신
        //최악의 경우 두 정점 사이 최단 거리가 N-1개의 간선으로 이어질 수 있으므로, N-1번 반복해야한다.
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                //Integer.MAX_VALUE 라면 그 정점으로부터 다른 정점으로 가는 경로가 없음을 의미한다.
                if (cost[edge.s] != Integer.MAX_VALUE
                        && cost[edge.e] > cost[edge.s] + edge.c)
                    cost[edge.e] = cost[edge.s] + edge.c;
            }
        }

        boolean cycle = false;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                //최단거리가 계속해서 갱신된다면 음수 사이클이 있다는 것
                //-> 최단거리가 무한히 작아진다는 것
                if (cost[edge.s] != Integer.MAX_VALUE
                        && cost[edge.e] > cost[edge.s] + edge.c)
                    cycle = true;
            }
        }

        //싸이클 확인
        if (!cycle) {
            for (int i = 2; i <= N; i++) {
                //갈 수 없는 정점인지 확인
                if (cost[i] != Integer.MAX_VALUE)
                    bw.write(cost[i] + "\n");
                else bw.write(-1 + "\n");
            }

        } else bw.write(-1 + "\n");
        bw.flush();
    }
}
