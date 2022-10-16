import java.util.Scanner;

public class Main {
     static double factorial(double x) {
        if(x>1)
            return x*factorial(x-1);
        else return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int i=0;i < T;i++) {
            double n,m;
            n= sc.nextDouble();
            m= sc.nextDouble();
            System.out.printf("%.0f\n",factorial(m)/(factorial(n)*factorial(m-n)));
        }

    }
}