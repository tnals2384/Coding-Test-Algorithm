import java.util.Scanner;

public class Main  {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int A=sc.nextInt();
        int B=sc.nextInt();
        int N=sc.nextInt();
        int div = A%B;
        for(int i=0; i<N;i++) {
            A=div*10;
            div=A%B;
        }
        System.out.println(A/B);
    }
}
