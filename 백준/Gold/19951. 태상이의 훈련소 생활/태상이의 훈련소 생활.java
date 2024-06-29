import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N+1];
        for(int i=1;i<=N;i++) {
            A[i] = stoi(st.nextToken());
        }
        int[] cmd = new int[N+2];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int k = stoi(st.nextToken());
            cmd[a]+=k;
            cmd[b+1]+=-k;
        }

        for(int i=1;i<=N;i++) {
            cmd[i] = cmd[i] + cmd[i-1];
        }

        for(int i=1;i<=N;i++) {
            A[i] += cmd[i];
            System.out.print(A[i] +" ");
        }


    }
}
