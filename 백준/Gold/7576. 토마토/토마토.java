import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
public class Main {
    public static class Point {
        int x;
        int y;
        int w;

        public Point(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] tomato = new int[M][N];
        Queue<Point> queue = new LinkedList<>();
        boolean zero = false;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 0) zero = true;
                else if (tomato[i][j] == 1)
                    queue.add(new Point(j, i, 0));
            }
        }
        int answer = 0;
        boolean[][] visited = new boolean[M][N];


        if (!zero) {
            System.out.println(0);
        } else {
            while (!queue.isEmpty()) {
                Point p = queue.poll();

                if (visited[p.y][p.x]) continue;

                answer = p.w;
                visited[p.y][p.x] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    if (tomato[ny][nx] == 0) {
                        tomato[ny][nx] = 1;
                        queue.add(new Point(nx, ny, p.w + 1));
                    }
                }
            }

            zero = false;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (tomato[i][j] == 0) {
                        zero = true;
                        break;
                    }
                }
            }

            if (zero) System.out.println(-1);
            else System.out.println(answer);

        }
    }
}
