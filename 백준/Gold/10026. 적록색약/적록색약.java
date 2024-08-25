import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int N;
    static String[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new String[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().split("");
        }

        int noBlind = 0;
        int blind = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    noBlind++;
                    visited[i][j] = true;
                    dfs(j,i);
                }
                if(grid[i][j].equals("G"))
                    grid[i][j] = "R";
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    blind++;
                    visited[i][j] = true;
                    dfs(j,i);
                }
            }
        }

        System.out.println(noBlind+" " +blind);

    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx])
                continue;

            if (grid[ny][nx].equals(grid[y][x])) {
                visited[ny][nx] = true;
                dfs(nx, ny);
            }
        }
    }
}
