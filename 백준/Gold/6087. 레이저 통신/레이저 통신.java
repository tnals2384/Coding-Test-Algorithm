import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static class Point {
        int x, y, d, count;

        public Point(int x, int y, int d, int count) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.count = count;
        }
    }

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static String[][] board;
    public static int[][][] visited;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        board = new String[N][M];
        visited = new int[N][M][4];

        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        boolean first = true;

        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = s[j];
                if (s[j].equals("C")) {
                    if (first) {
                        x1 = j;
                        y1 = i;
                        first = false;
                    } else {
                        x2 = j;
                        y2 = i;
                    }
                }
            }
        }

        for (int[][] arr : visited) {
            for (int[] row : arr) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            queue.add(new Point(x1, y1, i, 0));
            visited[y1][x1][i] = 0;
        }

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == x2 && now.y == y2) {
                min = Math.min(min, now.count);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int newCount = now.count + (now.d == d ? 0 : 1);

                if (check(nx, ny) && visited[ny][nx][d] > newCount) {
                    visited[ny][nx][d] = newCount;
                    queue.add(new Point(nx, ny, d, newCount));
                }
            }
        }

        System.out.println(min);
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N && !board[y][x].equals("*");
    }
}
