import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] A;
    static int min;
 
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][2]; //0번은 신맛, 1번은 쓴맛

        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        check(0, false, 1, 0);
        System.out.println(min);
    }

    public static void check(int depth, boolean used, int s, int b) {
        if (depth == N) {
            if (used) {
                min = Math.min(min, Math.abs(s - b));
            }
            return;
        }

        check(depth+1,true, s*A[depth][0], b+A[depth][1]);
        check(depth+1,used,s,b);
    }
}
