import java.util.*;

class Solution {

    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];

        dp[0] = land[0];
        for(int i = 1; i < n; i++) {
            for(int j=0; j < 4; j++) {
                for(int k=0; k < 4; k++) {
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k]);
                }
            }
        }
        Arrays.sort(dp[n-1]);
        return dp[n-1][3];
    }
    

}