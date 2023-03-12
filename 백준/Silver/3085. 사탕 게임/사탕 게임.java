import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N= sc.nextInt();
        int[][] board = new int[N][N];

        for(int i=0;i<N;i++) {
            String str= sc.next();
            for(int j=0;j<N;j++) {
                board[i][j]= str.charAt(j);

            }
        }

        int max=0;
        for(int i=0;i<N;i++) {
            for(int j=1;j<N;j++) {
                if(board[i][j-1]!=board[i][j]) {

                    board[i][j]=swap(board[i][j-1],board[i][j-1]=board[i][j]);
                    max=Math.max(max,check(N,board));
                    board[i][j]=swap(board[i][j-1],board[i][j-1]=board[i][j]);

                }
                if(board[j-1][i]!=board[j][i]) {

                    board[j][i]=swap(board[j-1][i],board[j-1][i]=board[j][i]);
                    max=Math.max(max,check(N,board));
                    board[j][i]=swap(board[j-1][i],board[j-1][i]=board[j][i]);

                }
            }
        }


        System.out.println(max);
    }

    static public int swap(int a,int b) {
        return a;
    }

    static public int check(int N, int[][] board) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int row = 1;
            int col = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j - 1] == board[i][j])
                    row++;
                else {
                    max = Math.max(row, max);
                    row = 1;
                }

                if (board[j - 1][i] == board[j][i])
                    col++;
                else {
                    max = Math.max(col, max);
                    col = 1;
                }

            }
            max = Math.max(max, col);
            max = Math.max(max, row);
        }
        return max;
    }
}
