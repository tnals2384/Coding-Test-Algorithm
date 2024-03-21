import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long total = Long.parseLong(br.readLine());
        Arrays.sort(A);

        long answer = 0;
        long left = 0;
        long right = A[N - 1];
        while(left <= right) {
            long middle =(right + left) / 2;
            long sum = 0;
            for(long money : A) {
                if(money >= middle)
                    sum += (middle);
                else
                    sum += money;
            }
            if(sum > total) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
                answer = Math.max(answer, middle);
            }
        }
        System.out.println(answer);


    }
}
