
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int N= sc.nextInt(); //정점 수
        int M= sc.nextInt(); //간선 수
        int V = sc.nextInt(); //정점 번호

        //행렬
        arr = new int[N+1][N+1];
        for(int i=0;i<M;i++) {
            int a=sc.nextInt();
            int b =sc.nextInt();
            //양방향 간선
            arr[a][b]=1;
            arr[b][a]=1;
        }

        visited= new boolean[N+1];
        dfs(V);

        System.out.println();

        visited= new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int V) { //깊이 우선
        visited[V]=true;
        System.out.printf(V+" ");

        for(int i=1;i<arr.length;i++) {
            if(arr[V][i]==1&& !visited[i]) {
                dfs(i);
            }
        }
    }


    public static void bfs(int V) { //넓이우선. 큐이용
        Queue<Integer> q=new LinkedList<>();
        q.add(V);
        visited[V]=true;
        System.out.printf(V+" ");

        while(!q.isEmpty()) {
            int x=q.poll();
            for(int i=1;i<arr.length;i++) {
                if(arr[x][i]==1 && !visited[i]) {
                    q.add(i);
                    visited[i]=true;
                    System.out.printf(i + " ");
                }
            }
        }
    }
}
