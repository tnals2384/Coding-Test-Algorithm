import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] A;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][2]; //0번은 신맛, 1번은 쓴맛
        visited = new boolean[N];

        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        check(0, 0, 1, 0);
        System.out.println(min);
    }

    public static void check(int depth, int count, int s, int b) {
        if (depth == N) {
            if (count != 0) {
                min = Math.min(min, Math.abs(s - b));
            }
            return;
        }

        visited[depth] = true;
        check(depth+1, count+1, s*A[depth][0], b+A[depth][1]);
        visited[depth] = false;
        check(depth+1,count,s,b);
    }
}
