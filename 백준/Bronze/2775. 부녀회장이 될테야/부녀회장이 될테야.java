import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] AB= new int[15][15];
        for(int i=0;i<15;i++) {
            AB[0][i]=i;
        }
        for(int i=1;i<15;i++) {
            for(int j=1;j<15;j++) {
                AB[i][j]=AB[i-1][j]+AB[i][j-1];
            }
        }

        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int i=0;i<T;i++) {
            int k= sc.nextInt();
            int n= sc.nextInt();
            System.out.println(AB[k][n]);
        }
    }
}