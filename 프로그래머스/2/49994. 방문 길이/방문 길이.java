class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    public int solution(String dirs) {
        int answer = 0;
        String[] cmd = dirs.split("");
        int[][] xline = new int[11][11];
        int[][] yline = new int[11][11];
        int x = 5;
        int y = 5;
        for(String dir : cmd) {
            int i = next(dir);
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx > 10 || ny < 0 || ny > 10)
                continue;
            
            if(i == 0) 
                yline[x][y] = 1;
            else if(i==1)
                yline[x][ny] = 1;
            else if(i==2)
                xline[y][x] = 1;
            else
                xline[y][nx] = 1;
            
            x=nx;
            y=ny;
        }
        
        for(int i=0;i<11;i++) {
            for(int j=0;j<11;j++) {
                answer+=xline[i][j];
                answer+=yline[i][j];
            }
        }
        
        return answer;
    }
    
    public int next(String dir) {
        if(dir.equals("D"))
            return 0;
        else if(dir.equals("U"))
            return 1;
        else if(dir.equals("L"))
            return 2;
        else return 3;
    }
}