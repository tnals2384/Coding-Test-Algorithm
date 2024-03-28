import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int min = sc.nextInt();
            int max = sc.nextInt();

            if(min > max)
                max = swap(min, min = max);

            //최대공배수 = (A*B) / 최대공약수
            System.out.println((min*max) / GCD(min, max));
        }
    }

    public static int GCD(int min, int max) {
        while(max % min != 0) {
            max = max % min;
            max = swap(min, min= max);
        }
        return min;
    }

    public static int swap(int min, int max) {
       return min;
    }
}
