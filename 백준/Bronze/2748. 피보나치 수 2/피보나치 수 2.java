import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] A=new long[91];
        A[0]=0;
        A[1]=1;
        for(int i=2;i<=N;i++) {
            A[i]=A[i-1]+A[i-2];
        }
        System.out.println(A[N]);
    }
}
    