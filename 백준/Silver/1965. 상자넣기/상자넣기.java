import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N - 1] + 1);
    }
}
