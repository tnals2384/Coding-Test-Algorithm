import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int[] sorted;
    static long count=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        A = new int[N];
        sorted = new int[N];
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        mergeSort(0,N-1);

        System.out.println(count);
    }

    private static void mergeSort(int s, int e) {
        if(e-s < 1)
            return;

        int m = (s+e)/2;

        mergeSort(s,m);
        mergeSort(m+1, e);

        int k = s;
        int idx1 = s;
        int idx2 = m + 1;

        while(idx1 <= m && idx2 <= e) {
            if(A[idx1] > A[idx2]) {
                sorted[k] = A[idx2];
                count += m+1-idx1;
                k++;
                idx2++;
            }
            else {
                sorted[k] = A[idx1];
                k++;
                idx1++;
            }

        }

        while(idx1 <= m) {
            sorted[k] = A[idx1];
            k++;
            idx1++;
        }
        while(idx2 <= e) {
            sorted[k] = A[idx2];
            k++;
            idx2++;
        }

        for(int i=s;i<=e;i++)
            A[i]= sorted[i];
    }
}
