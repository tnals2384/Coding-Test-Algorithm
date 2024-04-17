import java.util.*;
class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    public class Block {
        int x;
        int y;
        int w;
        public Block(int x, int y,int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
     
        Queue<Block> queue = new LinkedList<>();
        queue.add(new Block(0,0,1));
        
        while(!queue.isEmpty()) {
            Block now = queue.poll();
            if(now.x == n-1 && now.y == m-1)
                return now.w;
            
            maps[now.x][now.y] = 0;
            
            for(int i=0; i<4; i++) {
                int nextx = now.x + dx[i];
                int nexty = now.y + dy[i];
                
                if(nextx < 0 || nextx >= n||
                   nexty < 0 || nexty >= m)
                    continue;
        
                if(maps[nextx][nexty] == 1) {
                    queue.add(new Block(nextx,nexty, now.w+1));
                    maps[nextx][nexty] = 0;
                }
            }
        }
        return -1;
    }
}