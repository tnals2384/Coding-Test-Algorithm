import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        for(int t= 0;t<T;t++) {
            int N = sc.nextInt();
            int[] A = new int[N+1];

            for(int i=1;i<=N;i++)
                A[i] = sc.nextInt();

            int max = A[N];
            long sum = 0;
            for(int i = N-1;i>0;i--) {
                if(A[i] <= max)
                    sum += (max - A[i]);
                else
                    max=A[i];
            }

            System.out.println(sum);
        }
    }
}
