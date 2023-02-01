import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();

        long[] A= new long[N+1];

        A[1]=1;
        if(N>=2) A[2]=1;

        for(int i=3;i<=N;i++) {
            A[i]=A[i-1]+A[i-2];
        }

        System.out.println(A[N]);
    }
}
