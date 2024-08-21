import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][2];
        int small;
        int big;
        for (int i = 1; i <= n - 1; i++) {
            String[] s = br.readLine().split(" ");
            small = Integer.parseInt(s[0]);
            big = Integer.parseInt(s[1]);
            arr[i][0] = small;
            arr[i][1] = big;
        }
        k = Integer.parseInt(br.readLine());

        dfs(0, 1, false);
        System.out.println(answer);
    }

    private static void dfs(int sum, int to, boolean flag) {
        if (to == n) {
            answer = Math.min(answer, sum);
            return;
        }

        if (to > n) {
            return;
        }

        dfs(sum + arr[to][0], to + 1, flag); 
        dfs(sum + arr[to][1], to + 2, flag); 

        if (!flag) {
            dfs(sum + k, to + 3, true);
        }
    }
}
