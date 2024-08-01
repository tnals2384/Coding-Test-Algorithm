import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(calculate(M, N, x, y));
        }
    }

    //최소 공약수를 구하기
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else return gcd(b, a % b);
    }

    public static int calculate(int M, int N, int x, int y) {
        int gcd = gcd(M, N);
       
        for (int i = 0; i < N / gcd; i++) {
            if ((M * i + x - y) % N == 0)
                return M * i + x;
        }
        return -1;
    }
}
