import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    /**
     * R*C 격자판
     * r은 행, c는 열
     * 칸에는 상어가 최대 한마리
     * 상어는 크기와 속도를 가짐
     * 처음에 0,0에 있음
     * 1. 오른쪽으로 한칸 이동
     * 2. 해당 열의 상어 중 땅과 가장 가까운 상어 잡음. 잡으면 사라짐
     * 3. 상어가 주어진 속도로 이동
     * 상어가 이동하려고 하는 칸이 격자 판의 경계를 넘는 경우 반대로 이동
     * 한칸에 상어가 두마리 이상 있는 경우 크기가 큰 상어가 나머지 상어를 잡아먹음
     * 낚시왕이 잡은 상어 크기의 합
     * r, c, s, d, z (r,c 상어위치, s는 속력, d는 이동방향, z는 크기
     * 위아래오른쪽왼쪽 순으로 1234
     */

    public static final int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;

    public static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static int R;
    public static int C;
    public static Queue<Shark> queue;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); //행
        C = Integer.parseInt(st.nextToken()); //열
        int M = Integer.parseInt(st.nextToken()); //상어의 수

        Shark[][] board = new Shark[C + 1][R + 1];
        queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r, c, s, d, z);
            board[c][r] = shark;
        }

        for (int i = 1; i <= C; i++) {
            //열이 i이고, 행이 가장 작은 상어를 잡음
            catchShark(board, i);
            //queue 채우기
            fillQueue(board);
            
            //상어 이동 시킴
            board = new Shark[C + 1][R + 1];
            while (!queue.isEmpty()) {
                Shark shark = moveShark(queue.poll());

                if (board[shark.c][shark.r] == null || board[shark.c][shark.r].z < shark.z) {
                    board[shark.c][shark.r] = shark;
                }
            }
        }

        System.out.println(answer);
    }

    public static void fillQueue(Shark[][] board) {
        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {
                if (board[i][j] != null) {
                    queue.add(board[i][j]);
                }
            }
        }
    }

    public static void catchShark(Shark[][] board, int idx) {
        for (int i = 1; i <= R; i++) {
            if (board[idx][i] != null) {
                answer += board[idx][i].z;
                board[idx][i] = null;
                return;
            }
        }
    }

    public static Shark moveShark(Shark shark) {
        int s = shark.s;
        int r = shark.r;
        int c = shark.c;
        int d = shark.d;

        while (s != 0) {
            if (d == UP) {
                if (r - 1 == 0) {
                    d = DOWN;
                    r += 1;
                } else r -= 1;
            } else if (d == DOWN) {
                if (r + 1 == R + 1) {
                    d = UP;
                    r -= 1;
                } else r += 1;
            } else if (d == RIGHT) {
                if (c + 1 == C + 1) {
                    d = LEFT;
                    c -= 1;
                } else c += 1;
            } else if (d == LEFT) {
                if (c - 1 == 0) {
                    d = RIGHT;
                    c += 1;
                } else c -= 1;
            }
            s--;
        }

        return new Shark(r, c, shark.s, d, shark.z);
    }
}
