import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        //중복X 순열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        dfs("", 0);

    }


    public static void dfs(String s, int d) {
        if (d == M) {
            System.out.println(s.substring(1));
            return;
        }

        //중복되는 수열을 방지하기 위한 latest
        int latest = -1;
        for (int i = 0; i < N; i++) {
            if(visited[i] || latest == A[i]) continue;
            
            visited[i] = true;
            latest = A[i];
            dfs(s + " " + A[i], d + 1);
            visited[i] = false;
        }
    }
}
