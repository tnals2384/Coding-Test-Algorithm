import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int N,M;
    static int min=-1;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr= new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++) {
            String str= sc.next();
            for(int j=0;j<M;j++) {
                arr[i][j]=str.charAt(j)-'0';
            }
        }

        //dfs(0,0,0);
        //System.out.println(min);
        visited[0][0]=true;
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }


    public static void bfs(int x,int y) {
        //큐를 이용하여 풀이
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0;i<4;i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M) { //0~N,0~M 범위 내에 있고,
                    if (arr[nextX][nextY] == 1
                            && !visited[nextX][nextY]) { //1이고 방문하지 않았으면
                        q.add(new int[] {nextX,nextY}); //큐에 추가
                        arr[nextX][nextY]= arr[nowX][nowY]+1; //전 값에 1더해서 카운트
                        visited[nextX][nextY] = true; //방문체크
                    }
                }
            }
        }
    }
    public static void dfs(int x,int y,int count) { //dfs로 풀면 시간초과
        count++; //count 올리기

        //최종점에 도달했으면 최솟값 갱신
        if(x==N-1 && y==M-1) {
            if(min==-1)
                min=count;
            else
                min=Math.min(min,count);
            return;
        }

        visited[x][y]=true; //방문체크
        int nowX, nowY;

        for(int i=0;i<4;i++) { //동서남북으로 1씩 이동
            nowX = x+dx[i];
            nowY = y+dy[i];

            if(nowX>=0 && nowX<N && nowY>=0 && nowY<M) { //0~N,0~M 범위 내에 있고,
                if (arr[nowX][nowY] == 1
                        && !visited[nowX][nowY]) { //1이고 방문하지 않았으면
                    dfs(nowX, nowY, count); //dfs 재진행
                    visited[nowX][nowY] = false; //다른 탐색을 위해 방문 false 처리
                }
            }
        }
    }
}
