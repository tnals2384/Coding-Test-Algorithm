import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int[] km= new int[N];
        int[] cost = new int[N];
        
        for(int i=1;i<N;i++) {
            km[i]=sc.nextInt();
        }
        for(int i=0;i<N;i++) {
            cost[i]=sc.nextInt();
        }

        int sum=km[1]*cost[0];
        int min=cost[0];
        
        for(int i=2;i<N;i++) {
            min=Math.min(min,cost[i-1]);
            sum+= min*km[i];
        }

        System.out.println(sum);
    }
}
