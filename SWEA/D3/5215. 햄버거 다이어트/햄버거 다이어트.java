import java.time.Year;
import java.util.Scanner;

public class Solution {
    static int L;
    static int N;
    static int[] score;
    static int[] cal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            L = sc.nextInt();
            score = new int[N+1];
            cal = new int[N+1];
            int[][] dp  = new int[N+1][L+1];
            for(int i =1 ;i<=N;i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            for(int i=1;i<=N;i++) {
                for (int j = 1; j <= L; j++) {
                    //i번째 무게를 더 담을 수 없는 경우, 전 꺼 그대로
                    if (cal[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    //i번째 무게를 더 담을 수 있는 경우
                    //전 꺼랑, (무게가 j-cal[i]일때 가치 + 지금 가치) 를 비교해서 더 큰 것을 선택
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cal[i]] + score[i]);
                    }
                }
            }

            System.out.println("#"+test_case+" "+dp[N][L]);
        }

    }
}
