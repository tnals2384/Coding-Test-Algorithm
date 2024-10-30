import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 같은 양의 두용액 특성값 = 두 용액특성값의 합
     * 0에 가까워야함
     * 산성은 양수, 알칼리성은 음수 1억
     * 정렬된 순으로 주어질 때, 다른 용액을 혼합하여 0에 가까운 용액을 만들자
     * <p>
     * output : 가장 0에가까운 특성값을 만들어 내는 두 용액의 특성 값
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(s[i]);
        }

        int start = 0;
        int end = N - 1;
        int min = Math.abs(liquid[end] + liquid[start]);
        int A = liquid[start];
        int B = liquid[end];

        while (start < end) {
            int sum = liquid[end] + liquid[start];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                A = liquid[start];
                B = liquid[end];
            }

            if(sum > 0) {
                end--;
            }
            else start++;
        }

        System.out.println(A + " " + B);
    }
}
