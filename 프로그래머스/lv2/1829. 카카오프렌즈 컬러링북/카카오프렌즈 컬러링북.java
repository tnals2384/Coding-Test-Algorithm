import java.util.LinkedList;
import java.util.List;

class Solution {
     int[] dx ={1,-1,0,0};
    int[] dy ={0,0,1,-1};
    int count=0;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        List<Integer> size = new LinkedList<>();
        boolean[][] check = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(picture[i][j]!=0 && !check[i][j]) {
                    numberOfArea++;
                    dfs(i, j, check, picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                    count = 0;
                }
            }
        }
           
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void dfs(int x,int y,boolean[][] check,int [][] picture) {
       
        check[x][y]=true;
        count++;
        for(int i=0; i<4;i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if( X<0 || X >= picture.length  || Y < 0 || Y >= picture[0].length) continue;

            if(picture[X][Y]==picture[x][y] && !check[X][Y]) {
                dfs(X,Y,check,picture);
            }
        }
    }
}