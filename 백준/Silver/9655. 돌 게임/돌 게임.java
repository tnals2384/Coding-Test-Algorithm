import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //상근이가 먼저, 그리고 창영이
        //마지막 돌을 가져가는 사람이 이김
       if(N%2==0) System.out.println("CY");
       else System.out.println("SK");
    }
}
