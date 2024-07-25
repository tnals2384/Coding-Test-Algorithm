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

        int[] A = new int[N];
        int s = 1;
        int e = 1;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            s = Math.max(s, A[i]);
            e += A[i];
        }

        while (s <= e) {
            int mid = (s + e) / 2; //금액
            if (check(A, mid, M)) {
                e = mid - 1;
            } else s = mid + 1;
        }

        System.out.println(s);
    }


    public static boolean check(int[] A, int K, int M) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > K) {
                count++;
                sum = A[i];
            }
        }
        return count <= M; //뽑아야되는 횟수가 M보다 같거나 작으면 true
    }
}
