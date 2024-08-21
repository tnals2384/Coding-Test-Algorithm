import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MAX = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] small = new int[n + 1];
        int[] big = new int[n + 1];

        for (int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");
            small[i] = Integer.parseInt(s[0]);
            big[i] = Integer.parseInt(s[1]);
        }

        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = MAX;
            dp[i][1] = MAX;
        }


        if (n >= 2) dp[2][0] = small[1];
        if (n >= 3) dp[3][0] = Math.min(small[1] + small[2], big[1]);

        for (int i = 4; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + small[i - 1], dp[i - 2][0] + big[i - 2]);
            dp[i][1] = Math.min(dp[i - 3][0] + k, Math.min(dp[i - 1][1] + small[i - 1], dp[i - 2][1] + big[i - 2]));
        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
}
