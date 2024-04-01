import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int[][] city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        A = new int[N+1];
        city = new int[N+1][N+1];

        for(int i=1;i<N+1;i++)
            A[i]=i;

        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    union(i,j);
            }
        }


        st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));

        for(int i=1;i<M;i++) {
            int x = find(Integer.parseInt(st.nextToken()));

            if(root != x) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            A[b] = a;
    }

    private static int find(int a) {
        if(A[a]==a)
            return a;
        else return A[a] = find(A[a]);
    }
}
