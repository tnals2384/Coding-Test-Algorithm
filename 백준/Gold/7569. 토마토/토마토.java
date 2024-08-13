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
        int z;
        int w;

        public Point(int x, int y, int z, int w) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
        }
    }

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] tomato = new int[H][M][N];
        Queue<Point> queue = new LinkedList<>();
        boolean zero = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 0) zero = true;
                    else if (tomato[i][j][k] == 1)
                        queue.add(new Point(k, j, i, 0));
                }
            }
        }
        int answer = 0;

        if (!zero) {
            System.out.println(0);
        } else {
            while (!queue.isEmpty()) {
                Point p = queue.poll();

                answer = p.w;
                for (int i = 0; i < 6; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    int nz = p.z + dz[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M
                            || nz < 0 || nz >=H) continue;

                    if (tomato[nz][ny][nx] == 0) {
                        tomato[nz][ny][nx] = 1;
                        queue.add(new Point(nx, ny, nz, p.w + 1));
                    }
                }
            }

            zero = false;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < N; k++) {
                        if (tomato[i][j][k] == 0) {
                            zero = true;
                            break;
                        }
                    }
                }
            }

            if (zero) System.out.println(-1);
            else System.out.println(answer);

        }
    }
}
