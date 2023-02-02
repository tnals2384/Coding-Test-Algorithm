import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        //300초 60초 10초
        int N= sc.nextInt();

        int x=0;
        int A=0;
        int B=0;
        int C=0;
        while(x<N) {
            if(x+300<=N) {
                x += 300;
                A++;
            }
            else if(x+60<=N) {
                x += 60;
                B++;
            }
            else if(x+10<=N) {
                x += 10;
                C++;
            }
            else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(A +" "+B+" "+C);
    }
}
