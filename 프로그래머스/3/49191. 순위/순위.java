import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        //플로이드 워셜 알고리즘
        int[][] A = new int[n+1][n+1];
        
        //앞에있는 값이 이긴 애면 1, 진 애면 -1
        for(int[] result: results)  {
            A[result[0]][result[1]] = 1;
            A[result[1]][result[0]] = -1;
        }

        // A > B, B > C 이면 A > C 이다.
        for(int k = 1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n;j++) {
                    if(A[i][k] == 1 && A[k][j] == 1) {
                        A[i][j]=1;
                        A[j][i]=-1;
                    }
                    
                    if(A[i][k] == -1 && A[k][j]== -1) {
                        A[i][j] = -1;
                        A[j][i] = 1;
                    }
                }
            }
        }
        
        
        for(int i = 1; i <= n; i++)  {
            int count = 0;
           for(int j = 1; j <= n; j++) {
               if(A[i][j]!=0) count++;
           }
            if(count == n-1)
                answer++;
        }
        return answer;
    }
}