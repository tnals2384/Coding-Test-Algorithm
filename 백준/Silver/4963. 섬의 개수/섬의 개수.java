import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {1, -1, 0, 1, -1, 1, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (!(s = br.readLine()).equals("0 0")) {
            String[] st = s.split(" ");
            w = Integer.parseInt(st[0]);
            h = Integer.parseInt(st[1]);
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st[j]);
                }
            }
            int answer = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int y, int x) {
        if (visited[y][x]) return;
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;

            if (map[ny][nx] == 1) dfs(ny, nx);
        }
    }
}
