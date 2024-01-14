import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        long N =sc.nextLong();

        for(long i=0;i<N;i++) {
            System.out.println(prime(sc.nextLong()));
        }

    }

    public static long prime(long x) {
        //0,1,2 일 경우
        if (x <= 2) {
                return 2;
            }
        //제곱근 이용
        for(long i=x;;i++) {
            boolean flag = true;
            for(long j = 2; j <= Math.sqrt(i) + 1; j++) {
                if(i%j==0) {
                    flag= false;
                    break;
                }
            }
            if (flag) return i;
        }
    }
}
