import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[10];
        if(M!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                button[Integer.parseInt(st.nextToken())] = true;
            }
        }
        if(N==100) {
            System.out.println(0);
            return;
        }

        int result = Math.abs(100-N);

        for(int i=0;i<=999999;i++) {
            String num = String.valueOf(i);

            boolean flag = false;
            for(int j =0; j< num.length();j++) {
                if ( button[num.charAt(j)-'0']) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                int count = Math.abs(i-N) + num.length();
                result = Math.min(count, result);
            }
        }

        System.out.println(result);
    }
}
