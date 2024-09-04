import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    //가치의 합이 K원이 되어야하는데 N개중에 가치가 같은 동전도 있음
    //이 때 동전을 최소로 사용하여 가치를 만들 수 있는 개수
    //불가능한경우 -1을 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        int[] coin = new int[N];
        int[] dp = new int[K + 1];

        Arrays.fill(dp, 10001);
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if(coin[i] <= K)
                dp[coin[i]] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j <= coin[i]) continue;
                dp[j] = Math.min(dp[j], dp[coin[i]] + dp[j - coin[i]]);
            }
        }

        if (dp[K] == 10001) System.out.println(-1);
        else System.out.println(dp[K]);
    }
}
