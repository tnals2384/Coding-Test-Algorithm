import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
        char[][] miro = new char[N][M];
        int[][] visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = str.charAt(j);
                visited[i][j] = 0;
            }
        }
        
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0));
        visited[0][0] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                int x = node.x + dx[d];
                int y = node.y + dy[d];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (visited[x][y] == 0 && miro[x][y] == '1') {
                        queue.offer(new Node(x, y));
                        visited[x][y] = visited[node.x][node.y]+1;
                    }
                }
            }
        }
        System.out.println(visited[N-1][M-1]+1);
    }
}
