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
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long[] remain = new long[M];
        Arrays.fill(remain,0);

        long ans = 0;

        //구간합 구하기
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        //나머지의 개수를 저장
        for (int i = 0; i < N; i++) {
            remain[(int)(arr[i] % M)]++;
        }

        //나머지가 0이면 각각 하나하나가 구간이 되므로 answer에 더해줌
        ans += remain[0];

        //나머지가 같은 것들의 개수가 2보다 크다면, 나머지가 같은 것 2개를 빼면 나머지가 0이 되므로
        //같은 것들 중 2개를 고르는 조합을 더해줌
        for (int i = 0; i < M; i++) {
            if(remain[i]>1)
                ans += (remain[i]*(remain[i]-1))/2;
        }

        System.out.println(ans);

    }
}
