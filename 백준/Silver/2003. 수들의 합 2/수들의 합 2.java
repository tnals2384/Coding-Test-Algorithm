import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startIdx = 0;
        int endIdx = 0;
        int count = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum=0;

        //startIdx가 N을 넘기면 안 됨
        while(startIdx < N) {

            //부분합이 M보다 작을 경우 M보다 크거나 같아질 때까지 endIdx를 증가시킴
            if(sum < M && endIdx < N) {
                sum += arr[endIdx];
                endIdx++;
                continue;
            }
            //같으면 count
            if(sum == M)
                count++;

            //같지 않다면 startIdx를 증가시킴
            sum -= arr[startIdx];
            startIdx++;
        }

        System.out.println(count);
    }
}
