import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dp = new int[10001];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 10000; i++) {
            dp[i] = 1;
            dp[i] += dp[i-2];
        }
        for (int i = 3; i <= 10000; i++) {
            dp[i] += dp[i-3];
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
