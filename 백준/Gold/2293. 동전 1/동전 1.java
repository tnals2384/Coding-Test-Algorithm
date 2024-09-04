import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        int[] coin = new int[N];
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j < coin[i]) continue;
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[K]);
    }
}
