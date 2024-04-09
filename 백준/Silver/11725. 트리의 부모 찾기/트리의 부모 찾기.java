import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> [] A;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A =new ArrayList[N+1];
        answer = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++)
            A[i] = new ArrayList<>();

        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        visited[1]=true;
        dfs(1);

        for(int i=2;i<=N;i++)
            System.out.println(answer[i]);
    }

    public static void dfs(int s) {

        for(int now : A[s]) {
            if(visited[now]) continue;

            answer[now] = s;
            visited[now]= true;
            dfs(now);
        }
    }
}
