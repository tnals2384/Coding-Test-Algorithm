import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(String[] board) {
        int answer = -1;
        int N = board.length;
        int M = board[0].length();
        int[][] B = new int[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i].charAt(j) == 'R') {
                     queue.add(new int[] {j,i,0});
                }
                else if(board[i].charAt(j) == 'D') {
                    B[i][j] = -1;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if(board[now[1]].charAt(now[0]) == 'G') {
                answer = now[2];
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = now[0];
                int ny = now[1];
                
                while(nx + dx[i] >= 0 && nx + dx[i] < M &&
                      ny + dy[i] >= 0 && ny + dy[i] < N 
                     && B[ny + dy[i]][nx + dx[i]] != -1) {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                if(B[ny][nx] == 0 || B[ny][nx] > now[2] + 1) {
                    B[ny][nx] = now[2] + 1;
                    queue.add(new int[]{nx, ny, now[2] + 1});
                }
            }
            
        }
        return answer;
    }
}