import java.util.Scanner;

public class Main {
    static long A;
    static long B;
    static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(mul(B));
    }

    public static long mul(long n) {
        if (n == 0) return 1;

        long pow = mul(n / 2);
        if (n % 2 == 1)
            return pow * pow % C * A % C;
        else return pow * pow % C;
    }
}
