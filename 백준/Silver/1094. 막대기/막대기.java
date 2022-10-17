import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int stick=64;
        int sum=0;
        int count=0;
        while(sum != X) {
            if(X==stick) {
                count++;
                break;
            }
            if((stick/2)+sum > X) {
                stick=stick/2;
            }
            else if((stick/2)+sum <= X) {
                count++;
                sum+=stick/2;
            }
            
        }
        System.out.println(count);
    }
}
