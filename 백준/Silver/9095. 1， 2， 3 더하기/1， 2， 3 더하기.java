import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int[] A= new int[11];
        A[1]=1;
        A[2]=2;
        A[3]=4;
        for(int i=4; i<11;i++) {
            A[i]=A[i-1]+A[i-2]+A[i-3];
        }

        for(int i=0;i<T;i++) {
            int N= sc.nextInt();
            System.out.println(A[N]);
        }
    }
}
