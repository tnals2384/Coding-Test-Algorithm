import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();

        //X%3==0 이면 gogo
        //X%2==0 이면 gogo
        //1을 뺌

        //최솟값을 구하여라
        int[] A= new int[N+1];
        A[1]=0;
        for(int i=2;i<N+1;i++) {

            A[i]= A[i-1]+1;
            if(i%3==0) {
                A[i] = Math.min(A[i], A[i/3]+1);
            }
            if(i%2==0) {
                A[i] = Math.min(A[i], A[i/2]+1);
            }

        }
        System.out.println(A[N]);

    }
}
