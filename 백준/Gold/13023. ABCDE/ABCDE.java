import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean isPresent=false;
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        visited = new boolean[N];
        A = new ArrayList[N];

        for(int i=0;i<N;i++)
            A[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st =new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }

        for(int i=0;i<N;i++) {
            int count = 1;
            dfs(i, count);
            if(isPresent) {
                System.out.println(1);
                break;
            }
        }
        if(!isPresent)
            System.out.println(0);
    }

    public static void dfs(int s, int count) {

        if(count==5) {
            isPresent = true;
            return;
        }
        visited[s] = true;

        for(int i=0;i<A[s].size();i++) {
            int y = A[s].get(i);
            if (!visited[y]) {
                dfs(y,count+1);
            }
        }
        visited[s]=false;
    }
}
