import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /**
     * N A B
     * 사전순으로 가장 앞서는 N개의 건물의 높이를 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int A = Integer.parseInt(s[1]);
        int B = Integer.parseInt(s[2]);

        if (A + B > N + 1) {
            System.out.println(-1);
            return;
        }
        
        ArrayList<Integer> list = new ArrayList<>();

        int max = Math.max(A, B);

        for (int i = 1; i <= A - 1; i++) {
            list.add(i);
        }

        list.add(max);

        //뒤에서부터 B-1만큼 채우기
        for (int i = B - 1; i > 0; i--) {
            list.add(i);
        }

        while (A == 1 && list.size() < N) {
            list.add(1, 1);
        }

        while (A != 1 && list.size() < N) {
            list.add(0, 1);
        }


        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
