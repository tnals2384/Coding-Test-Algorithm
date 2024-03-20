import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] A;
    static boolean[] visited;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y =stoi(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }

        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);

    }

    public static void dfs(int start) {
        if(visited[start])
            return;
        
        visited[start]=true;
        for (int i : A[start]) {

            if (!visited[i]) {
                dfs(i);
                visited[i] = true;
            }
        }
    }

}
