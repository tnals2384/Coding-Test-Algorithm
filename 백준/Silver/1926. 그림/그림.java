import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] board = new int[N][M];
        boolean[][] visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxA = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Queue<Node> queue = new LinkedList<>();

                if (board[i][j] == 0 || visited[i][j])
                    continue;

                queue.offer(new Node(i, j));
                visited[i][j] = true;
                int area = 0;
                while (!queue.isEmpty()) {
                    area++;
                    Node node = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int x = node.x + dx[d];
                        int y = node.y + dy[d];

                        if (x >= 0 && x < N && y >= 0 && y < M) {
                            if (!visited[x][y] && board[x][y] == 1) {
                                queue.offer(new Node(x, y));
                                visited[x][y] = true;
                            }
                        }
                    }
                }
                maxA = Math.max(maxA,area);
                count++;
            }
        }

        System.out.println(count);
        System.out.println(maxA);
    }
}

