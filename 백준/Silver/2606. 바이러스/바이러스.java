import java.util.Scanner;

public class Main {
    static int[][] com;
    static boolean[] visited;
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //총 컴퓨터의 수
        int M =sc.nextInt(); //직접 연결되어 있는 컴퓨터 쌍 수
        com = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0;i<M;i++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            com[x][y]=1;
            com[y][x]=1;
        }

        dfs(1);

        System.out.println(count);

    }

    public static void dfs(int V) {
        visited[V]=true;
        for(int i=2;i<com.length;i++) {
            if(!visited[i] && com[V][i]==1) {
                count++;
                dfs(i);
            }
        }
    }
}
