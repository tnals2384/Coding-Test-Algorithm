import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0;i<T;i++) {
            int N= sc.nextInt();
            long[] P = new long[101];

            P[1]=1;P[2]=1;P[3]=1;
            P[4]=2;P[5]=2;
            if(N>5) {
                for(int j=6;j<=N;j++) {
                    P[j]=P[j-1]+P[j-5];
                }
            }

            System.out.println(P[N]);
        }
    }
}
