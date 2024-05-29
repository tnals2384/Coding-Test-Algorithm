import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1}; 
    int[] dy = {1, 0, -1, 0};
    Queue<int[]> queue;
    boolean[][][] visited;
    int N;
    public int solution(int[][] board) {
        int min = Integer.MAX_VALUE;
        N = board.length;
        queue = new LinkedList<>();
        visited = new boolean[N][N][4];

       
        queue.add(new int[] {0, 0, -1, 0});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
         
            if (now[0] == N - 1 && now[1] == N - 1) {
                min = Math.min(min, now[3]);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && board[ny][nx] != 1) {
                    int cost = 0;
                    if(now[2] == i || now[2]  == -1) cost = now[3] + 100;
                    else cost = now[3] + 600; 
                    
                    if(!visited[ny][nx][i] || board[ny][nx] >= cost) {
                        queue.add(new int[] {ny, nx, i, cost});
                        visited[ny][nx][i] = true;
                        board[ny][nx] = cost;
                    }
                }
            }
         }
        return min;
    }
    
    
}