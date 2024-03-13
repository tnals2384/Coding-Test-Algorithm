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
        //정렬
        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int startIdx = 0;
            int endIdx = N - 1;
            while (startIdx < endIdx) {
                if (arr[startIdx] + arr[endIdx] == arr[i]) {
                    //자기자신일 경우를 제외해야 함
                    if (startIdx != i && endIdx != i) {
                        count++;
                        break;
                    } else if (startIdx == i) {
                        startIdx++;
                    } else endIdx--;
                }
                else if (arr[startIdx] + arr[endIdx] < arr[i])
                    startIdx++;
                else {
                    endIdx--;
                }
            }
        }
        System.out.println(count);

    }
}
