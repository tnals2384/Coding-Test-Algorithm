import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();

        int[] A= new int[1001];

        A[1]=1;
        A[2]=3;
        for(int i=3;i<=N;i++) {
            A[i] = (A[i - 1] + 2*A[i - 2]) %10007;
        }

        System.out.println(A[N]);
    }
}