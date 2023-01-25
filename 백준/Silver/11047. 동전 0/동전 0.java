import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        int[] A = new int[N];
        int count=0;
        int max=0;
        
        for(int i=0;i<N;i++) {
            A[i]=sc.nextInt();
            if(A[i] <= K)
                max = i;
        }

        while(K>0) {
            if(A[max]<=K) {
                K -= A[max];
                count++;
            }
            else max-=1;
        }
        System.out.println(count);
    }

   
}
