import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 헛간 N개, 소의 길인 M개 양방향 길
     * C마리의 소
     * 소들의 길은 두개의 헛간을 이음
     * 두개의 헛간은 하나 이상의 길로 연결
     * 현서는 헛간 1에, 찬홍이는 헛간 N에
     * 최소 여물을 구하자
     * 다익스트라
     */

    public static class Node {
        int x;
        int c;

        public Node(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }

    public static ArrayList<Node>[] list;
    public static boolean[] visited;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        visited = new boolean[N + 1];
        A = new int[N + 1];
        Arrays.fill(A, Integer.MAX_VALUE);

        A[1] = 0;
        dijkstra(1);
        System.out.println(A[N]);
    }

    public static void dijkstra(int s) {

        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.c - o2.c));
        q.add(new Node(s,0));

        while(!q.isEmpty()) {
            Node n = q.poll();
            visited[n.x] = true;

            for(Node next : list[n.x]) {
                if (visited[next.x]) continue;

                if (next.c + A[n.x] < A[next.x]){
                    A[next.x] = next.c + A[n.x];
                    q.add(new Node(next.x, A[next.x]));
                }
            }
        }
    }
}
