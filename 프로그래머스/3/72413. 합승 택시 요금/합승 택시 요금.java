import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        long[][] node = new long[n+1][n+1];
        
        for(int i=1;i<=n;i++) {
            Arrays.fill(node[i], Integer.MAX_VALUE);
            node[i][i]=0;
        }
        
        for(int[] fare : fares) {
            node[fare[0]][fare[1]] = fare[2];
            node[fare[1]][fare[0]] = fare[2];
        }
        
        
        for(int k=1; k <= n; k++) {
            for(int i = 1;i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    node[i][j] = Math.min(node[i][j], node[i][k] + node[k][j]);
                }
            }
        }
        
        for(int k =1; k<=n;k++) {
            answer = (int) Math.min(answer, node[s][k] + node[k][a] + node[k][b]);
        }
        return answer;
    }
}