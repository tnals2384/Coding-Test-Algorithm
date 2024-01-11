import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        
        //시작시간 기준 정렬 -> 끝나는 시간 기준 정렬
        Arrays.sort(time,Comparator.comparingInt((int[] t)->t[0]).thenComparing(t->t[1]));

        PriorityQueue<Integer> end = new PriorityQueue<>();
        end.add(time[0][1]); 

        for (int i = 1; i < N; i++) {
            if (end.peek() <= time[i][0]) {
                end.poll();
            }
            end.add(time[i][1]);
        }
        System.out.println(end.size());
    }
}

