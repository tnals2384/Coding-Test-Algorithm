import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] hole = new int[N];

        hole[0]= sc.nextInt();
        for (int i = 1; i < N; i++) {
            hole[i] = sc.nextInt() + i;
            if(hole[i-1] > hole[i])
                hole[i] = hole[i-1];
        }

        int Q = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            int dotori = sc.nextInt();
            int left = 0;
            int right = N - 1;
            int result = N + 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (hole[mid] >= dotori) {
                    right = mid - 1;
                    result = right + 2;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(result).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
