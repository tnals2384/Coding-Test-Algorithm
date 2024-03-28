import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long length = gcd(A, B);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (long i = 0; i < length; i++)
            bw.write("1");

        bw.flush();
        bw.close();
    }

    public static Long gcd(Long A, Long B) {
        if (B == 0)
            return A;
        else
            return gcd(B, A % B);
    }
}
