import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N= sc.nextInt();
        int num[] = new int[N];
        for(int i=0;i<N;i++) {
            num[i]=sc.nextInt();
        }
        int sum=0;
        Arrays.sort(num);

        for (int i=0;i<N;i++) {
            if(sum +1 < num[i]) break;
            sum+=num[i];
        }

        System.out.println(sum+1);

    }
}
