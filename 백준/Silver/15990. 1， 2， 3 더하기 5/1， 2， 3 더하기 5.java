import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long[][] dp = new long[100001][3];
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[1][2] = 0;
        dp[2][0] = 0;
        dp[2][1] = 1;
        dp[2][2] = 0;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int i = 4; i <= 100000; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1000000009;
            dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % 1000000009;
            dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % 1000000009;
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 1000000009);
        }
    }
}
