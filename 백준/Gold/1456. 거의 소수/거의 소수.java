import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[] prime = new long[(int) (Math.sqrt(B)+1)];

        for (int i = 2; i < prime.length; i++) {
            prime[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i] == 0)
                continue;

            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = 0;
            }
        }

        ///소수 찾기 끝, 거의 소수 찾기
        int count = 0;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i] != 0) {
                long temp = prime[i];
                //곱셈이 long의 범위를 넘어 갈 수 있으므로 이항 정리로 처리
                while (prime[i] <= (double) B / temp) {
                    if (prime[i] >= (double) A / temp) {
                        count++;
                    }

                    temp *= prime[i];
                }
            }
        }

        System.out.println(count);


    }
}
