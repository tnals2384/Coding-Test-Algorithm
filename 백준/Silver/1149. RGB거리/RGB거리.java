import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A =new int[N][3];

        for(int i=0;i<N;i++) {
            for(int j=0;j<3;j++)
                A[i][j]=sc.nextInt();
        }

        for(int i=1;i<N;i++) {
            A[i][0]+=Math.min(A[i-1][1],A[i-1][2]);
            A[i][1]+=Math.min(A[i-1][0],A[i-1][2]);
            A[i][2]+=Math.min(A[i-1][0],A[i-1][1]);
        }

        int cost = Math.min(Math.min(A[N-1][0],A[N-1][1]),A[N-1][2]);

        System.out.println(cost);

    }
}