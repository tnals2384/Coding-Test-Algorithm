import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    public static class Cmd {
        int X;
        char C;

        public Cmd(int X, char C) {
            this.X = X;
            this.C = C;
        }
    }

    //1. 오른쪽 2.아래쪽 3.왼쪽 4. 왼쪽
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int N;

    public static class Point {
        int x;
        int y;
        int sec;

        public Point(int x, int y, int sec) {
            this.x = x;
            this.y = y;
            this.sec = sec;
        }
    }

    static int[][] board;
    static Queue<Cmd> cmd;
    static PriorityQueue<Point> snake = new PriorityQueue<>(Comparator.comparingInt(i -> i.sec));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //보드 크기
        int K = Integer.parseInt(br.readLine()); //사과 개수

        board = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            String[] cr = br.readLine().split(" ");
            int c = Integer.parseInt(cr[0]);
            int r = Integer.parseInt(cr[1]);
            board[c][r] = 1; //사과
        }

        int L = Integer.parseInt(br.readLine());

        cmd = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            String[] s = br.readLine().split(" ");
            cmd.add(new Cmd(Integer.parseInt(s[0]), s[1].charAt(0)));
        }

        board[1][1] = -1;
        snake.add(new Point(1, 1, 0));
        dfs(new Point(1, 1, 0), 0);
    }

    public static void dfs(Point head, int dir) {

        int nx = head.x + dx[dir];
        int ny = head.y + dy[dir];
        //벽 or 자기자신과 부딪혔을 때
        if (nx <= 0 || nx > N || ny <= 0 || ny > N || board[ny][nx] == -1) {
            System.out.println(head.sec + 1);
            return;
        }

        //다음 칸이 사과가 아니면 tail을 빼야함
        if (board[ny][nx] == 0) {
            Point tail = snake.poll();
            board[tail.y][tail.x] = 0;
        }

        board[ny][nx] = -1;
        Point newHead = new Point(nx, ny, head.sec + 1);
        snake.add(newHead);

        //방향 전환 체크
        if (!cmd.isEmpty() && cmd.peek().X == newHead.sec) {
            Cmd command = cmd.poll();
            if (command.C == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        
        dfs(newHead, dir);
    }
}
