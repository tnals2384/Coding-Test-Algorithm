import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[3];
        int[] B = new int[3];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            int minl = Math.min(A[0], A[1]);
            int maxl = Math.max(B[0], B[1]);
            int minr = Math.min(A[1], A[2]);
            int maxr = Math.max(B[1], B[2]);

            A[0] = a + minl;
            A[1] = b + Math.min(minl, minr);
            A[2] = c + minr;
            B[0] = a + maxl;
            B[1] = b + Math.max(maxl, maxr);
            B[2] = c + maxr;
        }
        System.out.print(Math.max(B[2], Math.max(B[0], B[1])));
        System.out.print(" ");
        System.out.print(Math.min(A[2], Math.min(A[0], A[1])));
    }

}
