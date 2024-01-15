import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();


        //BigInteger 사용
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;


        // 조합 공식: n! /(n-m!) *(m!)
        for(int i=0;i<m;i++) {
            numerator = numerator.multiply(new BigInteger(String.valueOf(n-i)));
            denominator = denominator.multiply(new BigInteger(String.valueOf(i+1)));
        }
        BigInteger ans = numerator.divide(denominator);

        System.out.println(ans);
    }

}
