import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M, H;
    public static int[][] ladder;
    public static int min = Integer.MAX_VALUE;
    static final int LEFT = 1;
    static final int RIGHT = 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);

        ladder = new int[H + 1][N + 1]; 

        for (int i = 0; i < M; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            ladder[a][b] = RIGHT;
            ladder[a][b + 1] = LEFT;
        }

        dfs(0, 1, 1);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }


    public static void dfs(int count, int x, int y) {
        if (count > 3) {
            return;
        }

        // 모든 세로선이 자기 자신으로 돌아오는지 확인
        if (check()) {
            min = Math.min(min, count);
            return;
        }
        
        for (int i = x; i <= H; i++, y = 1) {
            for (int j = y; j < N; j++) {
                if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                    ladder[i][j] = RIGHT;
                    ladder[i][j + 1] = LEFT;
                    dfs(count + 1, i, j + 2);
                    ladder[i][j] = 0;
                    ladder[i][j + 1] = 0;
                }
            }
        }
    }

    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            int pos = i;
            for (int j = 1; j <= H; j++) {
                if (ladder[j][pos] == RIGHT) {
                    pos++; // 오른쪽
                } else if (ladder[j][pos] == LEFT) {
                    pos--; // 왼쪽
                }
            }
            if (pos != i) {
                return false;
            }
        }
        return true;
    }
}
