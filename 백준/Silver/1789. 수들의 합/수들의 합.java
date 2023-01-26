import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Long S=sc.nextLong();

        Long count=0L;
        Long sum =0L;

        while(sum<S) {
         count++;
         sum+=count;
        }
        if(sum==S)
            System.out.println(count);
        else System.out.println(count-1);
    }
}