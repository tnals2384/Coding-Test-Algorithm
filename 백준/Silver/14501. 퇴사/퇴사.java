import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp =new int[N+1];

        for(int i=0;i<N;i++) {
            T[i]=sc.nextInt();
            P[i]=sc.nextInt();
        }


        for(int i=N-1; i>=0; i--) {

            if(i+T[i]>N) dp[i]=dp[i+1]; //N보다 커지면 더하지 못함

            else dp[i]=Math.max(dp[i+1],P[i]+dp[i+T[i]]);
        }
        System.out.println(dp[0]);
    }
}
