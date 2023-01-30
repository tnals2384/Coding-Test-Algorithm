import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int[] A = new int[1001];

        A[1]=1;
        A[2]=2;
        for(int i=3;i<N+1;i++) {
            A[i]=(A[i-1]+A[i-2])%10007;
        }

        System.out.println(A[N]);
    }
}
