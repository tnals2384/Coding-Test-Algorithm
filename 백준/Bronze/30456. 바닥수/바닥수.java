import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        String str = "";
        for (int i = 0; i < L - 1; i++)
            str += "1";
        str += N;

        System.out.println(str);
    }

}
