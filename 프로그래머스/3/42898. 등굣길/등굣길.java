import java.util.*;
class Solution {

  public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[m+1][n+1];


        for(int i=0;i < puddles.length; i++) {
            int y = puddles[i][0];
            int x = puddles[i][1];

            dp[y][x] = -1;
        }

        dp[1][1] = 1;
        for(int i=1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) continue;
                
                if(dp[i][j] == -1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
            }
        }

        return dp[m][n];

    }

    
}