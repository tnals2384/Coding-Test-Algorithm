import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Integer[] tip = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tip[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(tip, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int currentTip = tip[i] - i;
            if (currentTip <= 0) {
                break;
            }

            sum += currentTip;
        }

        System.out.println(sum);
    }
}

