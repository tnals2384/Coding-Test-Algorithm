import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int count=0;

    public int[] solution(int m, int n , int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(picture[i][j]!=0 && !check[i][j]) {
                    numberOfArea++;
                    bfs(i,j,picture,check);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,count);
                    count=0;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void bfs(int x,int y, int[][] picture, boolean[][] check) {
        Queue<Point> queue = new LinkedList<>();
        check[x][y]=true;
        count++;
        queue.offer(new Point(x,y));

        while(!queue.isEmpty()) {
            Point q=queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = q.x + dx[i];
                int Y = q.y + dy[i];
                if (X >= 0 && X < picture.length && Y >= 0 && Y < picture[0].length
                        && !check[X][Y] && picture[X][Y] == picture[x][y]) {
                    queue.offer(new Point(X, Y));
                    check[X][Y] = true;
                    count++;
                }
            }
        }
    }
}

