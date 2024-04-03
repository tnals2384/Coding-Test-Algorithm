import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        long[] A = new long[n+1];
        
        A[0] = 1;
        for(int i = 1;i <= n; i++) {
            for (int j = 0; j < i; j++) {
                A[i] += A[j] * A[i - j - 1];
            }
        }

        System.out.println(A[n]);

    }
}
