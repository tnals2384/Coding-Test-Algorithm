import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Integer> [] A;
    static int[] S;
    static boolean[] visited;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V+1];
            S = new int[V+1];
            visited = new boolean[V+1];
            for(int i=0;i<=V;i++) {
                A[i]= new ArrayList<Integer>();
            }
            for(int i=0;i<E;i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                A[u].add(v);
                A[v].add(u);
            }

            check = true;

            for(int i=1;i<=V;i++) {
                if(check)
                    dfs(i);
                else
                    break;
            }

            if(check)
                System.out.println("YES");
            else System.out.println("NO");

        }
    }

    private static void dfs(int i) {
        visited[i] = true;
        for(int x : A[i]) {
            if(!visited[x]) {
                S[x]= (S[i]+1) % 2;
                dfs(x);
            }
            else if(S[i]== S[x])
                check = false;
        }
    }
}
