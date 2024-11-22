import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N;
    public static int M;
    public static int[][] map;
    public static int count = -3;// 벽은 무조건 3개쳐야함
    public static int max = -1;

    public static Queue<Point> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        virus = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 2) virus.add(new Point(j, i));
                if (map[i][j] == 0) count++;
            }
        }

        comb(0, new ArrayList<>());
        System.out.println(max);
    }

    public static void comb(int idx, ArrayList<Integer> list) {
        if (list.size() == 3) {
            bfs(list);
            return;
        }

        for (int i = idx; i < N * M; i++) {
            if (map[i / M][i % M] != 0) continue;
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(i);
            comb(i + 1, newList);
        }
    }

    public static void bfs(ArrayList<Integer> list) {
        int[][] newMap = copy(map);
        //3개 벽 치고 시작
        for (int i : list) {
            newMap[i / M][i % M] = 1;
        }

        Queue<Point> queue = new LinkedList<>(virus);
        int virusCount = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (newMap[ny][nx] == 0) {
                    queue.add(new Point(nx, ny));
                    newMap[ny][nx] = 2;
                    virusCount++;
                }
            }
        }

        max = Math.max(max, count - virusCount);
    }

    public static int[][] copy(int[][] map) {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        return newMap;
    }
}
