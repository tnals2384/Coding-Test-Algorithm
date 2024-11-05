import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] num = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };
    static int N, K, P, X;
    static int[][] now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int answer = 0;

        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        P = Integer.parseInt(s[2]);
        X = Integer.parseInt(s[3]);

        if (s[0].length() < s[1].length())
            K = s[0].length();


        now = find(X);
        //P개를 반전시켜서 1~N을 만들 수 있는지를 체크?
        for (int i = 1; i <= N; i++) {
            if(i==X) continue;
            int[][] target = find(i);
            if(check(target)) answer++;
        }
        //X 제외
        System.out.println(answer);
    }

    public static boolean check(int[][] target) {
        int sum = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 7; j++) {
                if (now[i][j] != target[i][j]) {
                    sum++;
                }
                if (sum > P) return false;
            }
        }
        return true;
    }

    public static int[][] find(int X) {
        int[][] A = new int[K][7];
        for (int i = K - 1; i >= 0; i--) {
            A[i] = num[X % 10];
            X /= 10;
        }
        return A;
    }

}
