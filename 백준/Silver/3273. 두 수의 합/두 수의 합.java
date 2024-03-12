import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        int startIdx = 0;
        int endIdx = N-1;
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int count=0;
        int X = Integer.parseInt(br.readLine());

        while(startIdx < endIdx) {
            if(arr[startIdx] + arr[endIdx] == X) {
                count++;
                startIdx++;
                endIdx--;
            }
            else if(arr[startIdx]+arr[endIdx] < X)
                startIdx++;
            else if(arr[startIdx]+arr[endIdx] > X)
                endIdx--;
        }

        System.out.println(count);

    }
}
