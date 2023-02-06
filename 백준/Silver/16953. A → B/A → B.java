import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int count=1;
        while(B>A) {
            if(B%2==0) {
                B/=2;
                count++;
                continue;
            }
            if(B%10==1) {
                B/=10;
                count++;
            }
            else break;
        }
        if(B!=A) {
            System.out.println(-1);
            return;
        }


        System.out.println(count);
    }
}

