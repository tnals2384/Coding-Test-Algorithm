import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = now[0] + i;
                if (next == 100) {
                    System.out.println(now[1] + 1);
                    return;
                }
                if (next < 100 && !visited[next]) {
                    if (board[next] != 0) {
                        next = board[next];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(new int[]{next, now[1] + 1});

                    }
                }
            }
        }
    }
}