import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] S= new int[N];
        PriorityQueue<Integer> T = new PriorityQueue<>();

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
                S[i]=Integer.parseInt(st.nextToken());
                T.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(S);
        for(int i=0;i<N;i++) {
            if(T.isEmpty()) break;
            if(T.peek()<=S[i]) {
                T.poll();
            }
        }
        System.out.println(T.size());
    }
}
