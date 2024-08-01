import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String S = sc.next();
        int count = 0;
        int answer = 0;

        for (int i = 0; i < M - 1; i++) {
            if (S.startsWith("IOI", i)) {
                count++;
                i++;
                if (count == N) {
                    answer++;
                    count--;
                }
            } else count = 0;
        }

        System.out.println(answer);
    }
}
