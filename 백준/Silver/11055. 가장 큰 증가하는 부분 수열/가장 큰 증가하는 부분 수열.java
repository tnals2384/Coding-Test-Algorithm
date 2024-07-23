import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        //증가하는 부분 수열중 합이 가장 큰 것
        int[] dp = Arrays.copyOf(A, N);
        int max = A[0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j])
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
