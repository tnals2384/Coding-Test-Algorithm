import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(s[i]);
        }

        //연속합
        int[][] sum = new int[N][2]; //0-> 제거안함 1-> 제거함
        sum[0][0] = sum[0][1] = A[0];
        int max = A[0];
        for (int i = 1; i < N; i++) {
            sum[i][0] = Math.max(sum[i - 1][0] + A[i], A[i]);

            sum[i][1] = Math.max(sum[i - 1][0], sum[i - 1][1] + A[i]);

            max = Math.max(max, Math.max(sum[i][0], sum[i][1]));
        }

        System.out.println(max);
    }

}
