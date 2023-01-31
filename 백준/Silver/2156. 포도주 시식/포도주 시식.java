import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        int[] A= new int[N+1];
        int[] dp= new int[N+1];

        for(int i=1;i<=N;i++) {
            A[i]=sc.nextInt();
        }

        dp[0]=0;
        dp[1]=A[1];

        if(N>1)  //N이 1일경우 방지
            dp[2]=A[1]+A[2];

        for(int i=3;i<=N;i++) {
            dp[i]= Math.max(Math.max(dp[i-2],(dp[i-3]+A[i-1]))+ A[i],dp[i-1]);
        }
        
        System.out.println(dp[N]);
    }
}