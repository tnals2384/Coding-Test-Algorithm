import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] A;
    static String str="";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(line[j]);
            }
        }
        quadTree(0, 0, N);
        System.out.println(str);
    }

    public static void quadTree(int x, int y, int size) {
        int c = A[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (A[i][j] != c) {
                    str += "(";
                    quadTree(x, y, size / 2);
                    quadTree(x, y + size / 2, size / 2);
                    quadTree(x + size / 2, y, size / 2);
                    quadTree(x + size / 2, y + size / 2, size / 2);
                    str += ")";
                    return;
                }
            }
        }
        str += c;
    }

}
