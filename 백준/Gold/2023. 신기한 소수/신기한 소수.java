import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> A;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        A = new ArrayList<>();

        dfs(1,2);
        dfs(1,3);
        dfs(1,5);
        dfs(1,7);

        for(Integer prime : A)
            bw.write(prime + "\n");

        bw.flush();

    }
    public static void dfs(int n,int x) {
        if(n==N) {
            if(prime(x))
                A.add(x);
            return;
        }

        for(int i=0;i<10;i++) {
            if (prime(x*10+i)) {
                dfs(n+1,x*10+i);
            }

        }
    }
    public static boolean prime(int x) {
        if(x <= 1)
            return false;

        if(x % 2 == 0)
            return x == 2;

        for(int i = 3;i <= Math.sqrt(x); i+=2) {
            if(x % i == 0)
                return false;
        }
        return true;
    }

}
