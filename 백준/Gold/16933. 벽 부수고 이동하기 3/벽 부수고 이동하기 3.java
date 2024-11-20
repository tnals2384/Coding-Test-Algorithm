import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    static int M;

    static int K;

    static int[][] map;

    static class Node {
        int x;
        int y;
        boolean night;
        int count;
        int k;

        public Node(int x, int y, boolean night, int count, int k) {
            this.x = x;
            this.y = y;
            this.night = night;
            this.count = count;
            this.k = k;
        }
    }

    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            s = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        //낮과 밤이 존재하고, 낮에만 벽을 넘을 수 있음
        //가만이 잇어도 +1됨
        //가만이 잇어도 낮과밤이 바뀜
        visited = new boolean[N + 1][M + 1][K + 1];

        visited[1][1][K] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1, false, 1, K));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == M && now.y == N) {
                System.out.println(now.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (check(nx, ny)) {
                    if (map[ny][nx] == 1 && now.k > 0) { //벽을 깰수 잇음
                        if (goodVisited(nx, ny, now.k-1)) continue;

                        if (!now.night) {
                            queue.add(new Node(nx, ny, true, now.count + 1, now.k - 1));
                            visited[ny][nx][now.k - 1] = true;
                        } else {
                            queue.add(new Node(now.x, now.y, false, now.count + 1, now.k));
                        }
                    }

                    if (map[ny][nx] == 0) {
                        if (goodVisited(nx, ny, now.k)) continue;

                        visited[ny][nx][now.k] = true;
                        queue.add(new Node(nx, ny, !now.night, now.count + 1, now.k));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static boolean goodVisited(int nx, int ny, int k) {
        for (int i = k; i <= K; i++) {
            if (visited[ny][nx][i]) return true;
        }
        return false;
    }


    public static boolean check(int nx, int ny) {
        return nx > 0 && nx <= M && ny > 0 && ny <= N;
    }
}
