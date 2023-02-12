import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++) {
            int x= sc.nextInt();
            int y =sc.nextInt();

            int distance=y-x;

            int d=(int)Math.sqrt(distance);

            if( d== Math.sqrt(distance))
                System.out.println(d*2-1);
            else if(distance <= d*d+d)
                System.out.println(d*2);
            else System.out.println(d*2+1);
        }
    }
}
