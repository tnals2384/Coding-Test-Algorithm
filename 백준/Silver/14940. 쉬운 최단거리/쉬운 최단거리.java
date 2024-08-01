import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] board;
    static int[][] A;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        A = new int[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                A[i][j] = -1;

                if (board[i][j] == 2) {
                    A[i][j] = 0;
                    y = i;
                    x = j;
                }
                if (board[i][j] == 0)
                    A[i][j] = 0;
            }
        }

        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            x = now[0];
            y = now[1];
            int cost = now[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if (visited[ny][nx]) continue;
                if (board[ny][nx] == 0) continue;

                A[ny][nx] = cost;
                visited[ny][nx] = true;
                queue.add(new int[]{nx, ny,cost+1});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }


}
