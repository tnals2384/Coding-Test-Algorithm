import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[K + 1][N + 1];

        Arrays.fill(dp[1], 1);
        for (int i = 0; i <= K; i++)
            dp[i][0] = 1;

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= 1000000000;
            }
        }
        
        System.out.println(dp[K][N] % 1000000000);
    }
}
