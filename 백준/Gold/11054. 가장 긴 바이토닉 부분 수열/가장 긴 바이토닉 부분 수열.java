import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        //앞에서 부터 i까지 증가하는 수열과
        //뒤에서부터 i까지 증가하는 수열
        int[] max = new int[N];
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j])
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
            }
            max[i] += dp1[i];
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j])
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
            }
            max[i] += dp2[i];
        }

        Arrays.sort(max);


        System.out.println(max[N - 1] + 1);
    }
}
