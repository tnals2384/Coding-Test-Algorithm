
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] A = new int[N+1][M+1];
        int[][] B = new int[N+1][M+1];
        
        
        //+ or -, x1, y1, x2, y2, w
        for(int[] s : skill) {
            int flag = (s[0]==1) ? -1 : 1;
            int y1 = s[1];
            int x1 = s[2];
            int y2 = s[3];
            int x2 = s[4];
            int w = s[5];
        
            A[y1][x1] += flag * w;
            A[y1][x2+1] -= flag * w;
            A[y2+1][x1] -= flag * w;
            A[y2+1][x2+1] += flag * w;
        }
        
 
     
       for(int i=0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(i==0 && j==0) continue;
                
                if(i==0) A[i][j] += A[i][j-1];
                else if(j==0) A[i][j] += A[i-1][j];
                else A[i][j] += A[i-1][j] + A[i][j-1] - A[i-1][j-1];
            
            }
        }

       for(int i=0;i < N;i++) {
            for(int j = 0; j < M;j++) {
                board[i][j]+=A[i][j];
                if(board[i][j]>0) answer++;
            }
        }
        return answer;
    }
}