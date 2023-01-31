import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N= sc.nextInt();
        int[][] triangle= new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=i;j++)
                triangle[i][j]= sc.nextInt();
        }
        dp[1][1]=triangle[1][1];

        for(int i=2;i<=N;i++) {
            for(int j=1;j<=i;j++) {
                dp[i][j]= triangle[i][j]+ Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        Arrays.sort(dp[N]);
        System.out.println(dp[N][N]);
    }
}