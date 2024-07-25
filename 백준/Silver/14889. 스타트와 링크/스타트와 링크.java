import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] S;
    static int N;
    static int[] team;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        team = new int[N / 2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //N개중에 N/2개를 구하는 조합을 먼저 구함
        comb(0, 0);

        System.out.println(min);

    }

    public static void comb(int depth, int count) {
        if (count == N / 2) {
            //될 수 있는 start와 link 시너지의 차를 구함
            boolean[] check = new boolean[N];
            for (int i : team) {
                check[i] = true;
            }
            calculate(check);
            return;
        }

        for (int i = depth; i < N; i++) {
            team[count] = i;
            comb(i + 1, count + 1);
        }

    }

    public static void calculate(boolean[] check) {
        int start = 0, link = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i] && check[j]) {
                    start += S[i][j];
                } else if (!check[i] && !check[j])
                    link += S[i][j];
            }
        }
        min = Math.min(Math.abs(start - link), min);
    }
}
