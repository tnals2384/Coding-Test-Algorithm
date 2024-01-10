import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] height = new long[N];
        long[] minus = new long[N-1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            height[i] = Long.parseLong(st.nextToken());
            if (i > 0)
                 minus[i-1]=(height[i] - height[i - 1]);
        }

        long count=0;
        minus =Arrays.stream(minus).sorted().toArray();
        for(int i=0;i<N-K;i++)
            count+=minus[i];
        System.out.println(count);
    }
}

