import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] B =new int[M];


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)
            B[i] = Integer.parseInt(st.nextToken());

        //1 정렬
        Arrays.sort(A);

        for(int target : B) {
            System.out.println(search(target, 0,N-1));
        }
    }

    public static int search(int target, int start, int end) {
        int mid = (start+end)/2;

        if(end-start <= 1) {
            if(A[start] == target)
                return 1;
            else if(A[end] == target)
                return 1;
            else
                return 0;
        }

        if(target == A[mid])
            return 1;
        else if (target > A[mid]) {
            return search(target, mid+1, end);
        }
        else
            return search(target, start, mid-1);
    }
}
