import java.util.*;
class Solution {
    public class Node {
        int x;
        int y;
        int w;
        
        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] board = new int[102][102];
          boolean[][] visited = new boolean[102][102];
           for(int i=0;i<102;i++) {
            for(int j=0;j<102;j++) 
                board[j][i]=2;
        }
        
        for(int k=0;k<rectangle.length;k++) {
            int lbx = rectangle[k][0]*2;
            int lby = rectangle[k][1]*2;
            int rtx = rectangle[k][2]*2;
            int rty = rectangle[k][3]*2;
            
            
            
            for(int i= lbx;i<=rtx;i++) {
             for(int j= lby; j<=rty;j++) {
                 if(i== lbx || i==rtx || j==lby || j==rty) {
                     if(board[j][i]!=0) {
                         board[j][i]=1;
                     }
                 }
                 else board[j][i]=0;
                }
            }
        }
        
    
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(characterX*2, characterY*2,0));
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if(now.x == itemX*2 && now.y == itemY*2)
                return now.w/2;
            
            for(int i=0;i<4;i++) {
                int x = now.x+dx[i];
                int y = now.y+dy[i];
                
                if(x<2 || x > 100 || y<2 || y>100)
                    continue;
                
                if(board[y][x]==1 && !visited[y][x]) {
                    queue.add(new Node(x,y,now.w + 1));
                    visited[y][x]=true;
                }
            }
            
        }

        return answer;
    }
}