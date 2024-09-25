import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static class State {
        Point red;
        Point blue;
        int count;

        public State(Point red, Point blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
        }
    }

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static String[][] board;
    public static Point red;
    public static Point blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (line[j].equals("R")) {
                    red = new Point(j, i);
                } else if (line[j].equals("B")) {
                    blue = new Point(j, i);
                }
                board[i][j] = line[j];
            }
        }

        System.out.println(bfs());
    }

    //이동을 하게 해야되는데
    public static int bfs() {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(red, blue, 0));

        while (!queue.isEmpty()) {
            State now = queue.poll();
            if (now.count >= 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                Point red = movePoint(now.red, i);
                Point blue = movePoint(now.blue, i);

                //파랑거 빠지면 실패
                if (checkHole(blue.x, blue.y)) {
                    continue;
                }

                //빨간거 빠지면 성공
                if (checkHole(red.x, red.y)) {
                    return now.count + 1;
                }

                //빨간거 파랑거 겹쳤을 때 더 앞에있는거를 판단해서 처리
                if (red.x == blue.x && red.y == blue.y) {
                    //더 많이 움직인거를 하나씩 빼야됨
                    if (getDistance(now.red, red) > getDistance(now.blue, blue)) {
                        red.x -= dx[i];
                        red.y -= dy[i];
                    } else {
                        blue.x -= dx[i];
                        blue.y -= dy[i];
                    }
                }
                queue.add(new State(red, blue, now.count + 1));
            }
        }

        return -1;
    }

    public static boolean checkHole(int x, int y) {
        return board[y][x].equals("O");
    }

    public static Point movePoint(Point p, int i) {
        int nx = p.x;
        int ny = p.y;
        while (!board[ny + dy[i]][nx + dx[i]].equals("#")) {
            nx += dx[i];
            ny += dy[i];

            if (board[ny][nx].equals("O")) break;
        }

        return new Point(nx, ny);
    }

    public static int getDistance(Point op, Point np) {
        return Math.abs(op.x - np.x) + Math.abs(op.y - np.y);
    }
}
