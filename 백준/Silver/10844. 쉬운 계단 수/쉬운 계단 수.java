import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(9);
            return;
        }

        long[][] A = new long[N][10];

        for (int i = 1; i <= 9; i++) {
            A[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    A[i][j] = A[i - 1][1];
                } else if (j == 9) {
                    A[i][j] = A[i - 1][8];
                } else {
                    A[i][j] = A[i - 1][j - 1] + A[i - 1][j + 1];
                }
                A[i][j] %= 1000000000;
            }
        }

        long count = 0;
        for (int i = 0; i <= 9; i++) {
            count += A[N - 1][i];
        }

        System.out.println(count % 1000000000);
    }
}
