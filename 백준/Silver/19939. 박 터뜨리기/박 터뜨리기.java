import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[K+1];

        for(int i=1;i<=K;i++) {
            N -= i;
            if(N < 0) {
                System.out.println(-1);
                return;
            }
            A[i] = i;
        }

        if(N%K==0)
            System.out.println(K-1);
        else System.out.println(K);
    }


}
