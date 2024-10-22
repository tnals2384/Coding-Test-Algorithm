import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //같은 수가 K개 이하로 들어있는 최장 연속 수열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int s = 0;
        int e = 0;
        int max = 0;

        while (e < N) {
            while (e < N && count[A[e]] + 1 <= K) {
                count[A[e]]++;
                e++;
            }
            
            max = Math.max(max, e - s);
            count[A[s]]--;
            s++;
        }

        System.out.println(max);
    }
}
