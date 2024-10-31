import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /**
     * N개 지역
     * 1~N까지 번호
     * 횡단보도 주기는 총 M분
     * 1분마다 신호가 바뀜 (횡단보도가 M개)
     * 각 주기의 1+i번째 신호는 i, M+i, 2M+i, 3M+i 분에시작해서 1분동안 파란불
     * 다른 모든 횡단보도에는 빨간불 , 한주기동안 같은 횡단보도에 파란불이 여러번 가능
     * 건너는데 1분, 건너는 도중 빨간불이 되면 안돼서 반드시 s~e-1시간에 횡단보도를 건너기 시작해야함
     * 시간 0분에서 시작해서 1~N까지가는 최소시간
     * 1번부터 시작하는 다익스트라
     */

    public static class Node {
        int x;
        int seq;
        long time;

        public Node(int x, int seq, long time) {
            this.x = x;
            this.seq = seq;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, i, i));
            graph[B].add(new Node(A, i, i));
        }

        long[] A = new long[N + 1];
        Arrays.fill(A, Long.MAX_VALUE);
        A[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.time, o2.time));
        pq.add(new Node(1, 0, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.x == N){
                System.out.println(A[now.x]);
                break;
            }

            if (visited[now.x]) continue;
            visited[now.x] = true;

            for (Node next : graph[now.x]) {
                long waitTime = (M - (now.time % M) + next.seq) % M;
                if (waitTime == 0 && (now.time % M) > next.seq) {
                    waitTime = M;
                }

                long totalTime = now.time + waitTime + 1;
                
                if (totalTime < A[next.x]) {
                    A[next.x] = totalTime;
                    pq.add(new Node(next.x, next.seq, totalTime));
                }
            }
        }
    }
}
