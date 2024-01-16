import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for(int i=0;i<N;i++) {
            board[i] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        long[][] visited = new long[N][N];

        visited[0][0] = 1;

        //반드시 오른쪽 or 아래쪽으로만 이동
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {

                if (visited[i][j]==0 || (i==N-1 && j==N-1))
                    continue;

                //이동할 수 있는 범위 내에서
                if (board[i][j] + j < N)
                    visited[i][j + board[i][j]] += visited[i][j];
                if (board[i][j] + i < N)
                    visited[i + board[i][j]][j] += visited[i][j];
            }
        }

        System.out.println(visited[N-1][N-1]);

    }
}
