import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int s = 0;
        int odd = 0;
        int max = 0;
        for (int e = 0; e < N; e++) {
            if (A[e] % 2 != 0) odd++;

            while (odd > K) {
                if (A[s] % 2 != 0)
                    odd--;
                s++;
            }
            max = Math.max(max, e - s + 1 - odd);
        }
        System.out.println(max);
    }
}
