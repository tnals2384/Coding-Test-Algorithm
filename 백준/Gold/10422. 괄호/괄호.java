import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[2500 + 1]; 
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j <= i-1; j++) {
                dp[i] += (dp[j] * dp[i - j-1]) % 1000000007;
                dp[i] %=1000000007;
            }
        }

        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x % 2 != 0) System.out.println(0);
            else {
                System.out.println(dp[x/2]);
            }
        }
    }

}
