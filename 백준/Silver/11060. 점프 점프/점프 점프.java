import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(s[i]);
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1001);
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < i - j) continue;

                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }

        if (dp[N - 1] == 1001) System.out.println(-1);
        else System.out.println(dp[N - 1]);
    }
}
