import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String S = sc.next();
        int count = 0;

        //N은 O의 개수이다.
        String P = "I" + "OI".repeat(N);

        for (int i = 0; i < M - N; i++) {
            if (S.startsWith(P, i))
                count++;
        }

        System.out.println(count);
    }
}
