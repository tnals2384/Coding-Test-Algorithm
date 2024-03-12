import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx = 0;
        int min = N+1;
        int sum = 0;

        while (startIdx <= N) {
            if (sum < S && endIdx < N) {
                sum += arr[endIdx];
                endIdx++;
                continue;
            }

            if (sum >= S) {
                min = Math.min(min, endIdx - startIdx);
            }

            if(startIdx==N) break;
            sum -= arr[startIdx];
            startIdx++;
        }

        if (min == N+1)
            System.out.println(0);
        else
            System.out.println(min);
    }
}


