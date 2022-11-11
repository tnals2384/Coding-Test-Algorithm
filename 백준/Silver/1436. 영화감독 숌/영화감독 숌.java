import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int count=0;
        int answer=0;
        int i=666;
        while(true) {
            if(count==N) break;
            Integer a = i;
            if(a.toString().contains("666") ) {
                count++;
                answer=i;
            }
            i++;
        }
        System.out.println(answer);
    }
}