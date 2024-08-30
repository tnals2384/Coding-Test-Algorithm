import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] A = new int[2][N + 1];

            for (int i = 0; i <= 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++)
                    A[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][N + 1];
            dp[0][1] = A[0][1];
            dp[1][1] = A[1][1];

            for (int i = 2; i <= N; i++) {
                dp[0][i] = A[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
                dp[1][i] = A[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
