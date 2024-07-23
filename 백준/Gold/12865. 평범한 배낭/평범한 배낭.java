import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt(); //물품의 수
        int K = sc.nextInt(); //버틸 수 있는 무게
        int[] W = new int[N+1];
        int[] V = new int[N+1];

        for(int i=1;i<=N;i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        //배낭에 넣을 수 있는 물건들의 V합의 최댓값
        int[] dp = new int[K+1];
        for(int i=0;i<=N;i++) {
            for(int j=K;j>=0;j--) {
                if(j >= W[i]) { //배낭에 넣을 수 있다면
                    dp[j]=Math.max(dp[j], dp[j-W[i]]+V[i]);
                }
            }
        }
        System.out.println(dp[K]);
        
        /*
        2차원 배열 사용
         */
        /*
        int[][] dp = new int[N+1][K+1];

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=K;j++) {

                if(W[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
                }
            }
        }*/

        //System.out.println(dp[N][K]);
    }
}
