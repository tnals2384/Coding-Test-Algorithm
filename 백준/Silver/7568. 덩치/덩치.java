import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N= sc.nextInt();
        int[] ans= new int[N];
        int[] x= new int[N];
        int[] y =new int[N];

        for(int i=0;i<N;i++) {
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }

        for(int i=0;i<N;i++) {
            int count=1;
            for(int j=0;j<N;j++) {
                if(x[i]<x[j] && y[i]<y[j])
                    count++;
            }
            ans[i]=count;
            if(i==N-1) System.out.printf(ans[i]+"");
            else System.out.printf(ans[i]+" ");
        }

    }
}
