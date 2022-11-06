import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int me=sc.nextInt();
        if(N==1 || N==0) {
            System.out.println(0);
            return;
        }
        int[] arr =new int[N-1];
        for(int i=0;i<N-1;i++) {
            arr[i]=sc.nextInt();

        }
        int count=0;
        while(true) {
            Arrays.sort(arr);
            if (me <= arr[N-2]) {
                me += 1;
                arr[N-2]-=1;
                count++;
            }
            else break;
        }

        System.out.println(count);
    }
}
