import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long result = n;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {     //소인수이면
                result = result - result / i;

                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) //소인수가 남아 있을 경우 (제곱근까지만 탐색해서 1개의 소인수가 누락될 수 있음)
            result = result - result / n;

        System.out.println(result);
    }
}
