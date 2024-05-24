import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 어떤 수가 다른 수 두개의 합으로 나타낼 수 있으면 좋음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        //1. 정렬
        Arrays.sort(arr);
        int count=0;
        //2. 투포인터 시작
        for(int i = 0;i < N; i++) {
            int start = 0;
            int end = N-1;

            while(start < end) {
                if(start == i)
                    start++;
                else if(end == i)
                    end--;
                else {
                    if (arr[start] + arr[end] < arr[i])
                        start++;
                    else if (arr[start] + arr[end] > arr[i])
                        end--;
                    else {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);

    }
}
