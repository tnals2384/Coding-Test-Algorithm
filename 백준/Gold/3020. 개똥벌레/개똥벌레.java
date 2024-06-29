import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();

        int[] sum = new int[H + 1];
        int s;
        int e;
        for (int i = 0; i < N; i++) {
            if ((i + 1) % 2 != 0) {
                s = 0;
                e = sc.nextInt();
            } else {
                s = H - sc.nextInt();
                e = H;
            }

            sum[s]++;
            sum[e]--;
        }

        for (int i = 1; i < H; i++) {
            sum[i] += sum[i - 1];
        }

        sum = Arrays.copyOfRange(sum, 0, H);
        Arrays.sort(sum);

        int min = sum[0];
        int answer = 0;

        for (int i = 0; i < H; i++) {
            if (min < sum[i]) break;
            answer++;
        }

        System.out.println(min + " " + answer);
    }


}
