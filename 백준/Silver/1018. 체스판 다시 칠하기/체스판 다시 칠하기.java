import java.util.Scanner;

public class Main {
    public static boolean board[][];
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        board= new boolean[N][M];

        for(int i=0;i<N;i++) {
            String str= sc.next();
            for(int j=0;j<M;j++) {
                if(str.charAt(j)=='W') {
                    board[i][j] = true;
                }
                else {
                    board[i][j] = false;
                }
            }
        }

        int N_row = N-7;
        int M_col =M-7;
        int min=64;
        for(int i=0;i<N_row;i++) {
           for(int j= 0;j<M_col;j++) {
               min=Math.min(min,find(i,j));
           }
        }

        System.out.println(min);
    }

    public static int find(int x, int y) {
        int count=0;
        boolean TF = board[x][y];
        for(int i= x;i <x+8;i++) {
            for(int j=y;j <y+8;j++) {
                if(board[i][j]!=TF) {
                    count++;
                }
                TF = (!TF);
            }
            TF = (!TF);
        }
        count = Math.min(count, 64-count);
        return count;
    }
}
