import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static int N;
    public static long[][] dp;
    public static int[] A;
    //등식을 만들 수 있는 경우의 수
    //마지막 수를 만드는 식을 구하라
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(s[i]);
        }

        dp = new long[N][21];
        dp[0][A[0]] = 1;
        find(1);
    }

    public static void find( int d) {

        if (d == N - 1) {
            System.out.println(dp[N - 2][A[N - 1]]);
            return;
        }
        for (int i = 0; i <= 20; i++) {
            if (dp[d - 1][i] == 0) continue;
            if (check(i + A[d])) {
                dp[d][i + A[d]] += dp[d - 1][i];
            }

            if (check(i - A[d])) {
                dp[d][i - A[d]] += dp[d - 1][i];
            }
        }

        find(d + 1);
    }

    public static boolean check(int sum) {
        return sum >= 0 && sum <= 20;
    }
}
