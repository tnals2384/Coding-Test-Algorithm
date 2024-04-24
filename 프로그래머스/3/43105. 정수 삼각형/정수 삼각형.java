import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int [][] dp = new int [n][n+1];
        
        dp[0][1]=triangle[0][0];
        
        for(int i=1;i<n;i++) {
            for(int j = 1; j <=i+1; j++) {
                dp[i][j]= triangle[i][j-1] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        int max =-1;
        for(int i=0;i<dp[n-1].length;i++)
            max = Math.max(max,dp[n-1][i]);
        return max;
    }
}