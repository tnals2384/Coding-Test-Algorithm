import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i + 1] = Integer.parseInt(s[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];

        //dp를 미리 계산해놓기
        for (int i = 1; i <= N; i++) {
            //길이 1
            dp[i][i] = 1;

            //길이 2
            if (A[i] == A[i - 1]) dp[i - 1][i] = 1;
        }

        //길이가 3이상일 경우
        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (A[j] == A[j + i] && dp[j + 1][j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] m = br.readLine().split(" ");
            int S = Integer.parseInt(m[0]);
            int E = Integer.parseInt(m[1]);

            sb.append(dp[S][E]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
