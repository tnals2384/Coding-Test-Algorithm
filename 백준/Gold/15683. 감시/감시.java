import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] A;
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Point> cctv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] > 0 && A[i][j] < 6)
                    cctv.add(new Point(j, i));
            }
        }

        find(A, 0);

        System.out.println(min);
    }

    public static void find(int[][] A, int cnt) {

        if (cnt == cctv.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i][j] == 0) count++;
                }
            }
            min = Math.min(count, min);
            return;
        }

        int x = cctv.get(cnt).x;
        int y = cctv.get(cnt).y;

        if (A[y][x] == 1) {
            for (int k = 0; k < 4; k++) {
                int[][] B = copy(A);
                watch(B, y, x, k);
                find(B, cnt + 1);
            }
        } else if (A[y][x] == 2) {
            for (int k = 0; k < 2; k ++) {
                int[][] B = copy(A);

                watch(B, y, x, k);
                watch(B, y, x, k + 2);
                find(B, cnt + 1);
            }
        } else if (A[y][x] == 3) {
            for (int k = 0; k < 4; k++) {
                int[][] B = copy(A);

                watch(B, y, x, k % 4);
                watch(B, y, x, (k + 1) % 4);
                find(B, cnt + 1);

            }
        } else if (A[y][x] == 4) {
            for (int k = 0; k < 4; k++) {
                int[][] B = copy(A);

                watch(B, y, x, k % 4);
                watch(B, y, x, (k + 1) % 4);
                watch(B, y, x, (k + 2) % 4);
                find(B, cnt + 1);
            }
        } else if (A[y][x] == 5) {
            int[][] B = copy(A);

            watch(B, y, x, 0);
            watch(B, y, x, 1);
            watch(B, y, x, 2);
            watch(B, y, x, 3);
            find(B, cnt + 1);
        }

    }

    public static void watch(int[][] A, int y, int x, int i) {
        while (true) {
            x += dx[i];
            y += dy[i];

            if (x < 0 || x >= M || y < 0 || y >= N) return;
            if (A[y][x] == 6) return;
            else if (A[y][x] == 0) A[y][x] = -1;
        }
    }

    public static int[][] copy(int[][] original) {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }
}

