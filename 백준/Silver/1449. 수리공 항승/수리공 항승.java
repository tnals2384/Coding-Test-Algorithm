import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int L= Integer.parseInt(st.nextToken());
        int[] X= new int[N];

        st =new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            X[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(X);
        int count=1;
        int now=0;
        for(int i=1;i<N;i++) {
            now+=X[i]-X[i-1];
            if(now>=L) {
                count++;
                now=0;
            }
        }
        System.out.println(count);

    }
}
