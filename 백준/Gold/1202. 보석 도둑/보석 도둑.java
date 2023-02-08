import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Jewelry {
        int m;
        int v;

        public Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewelry[] jewel= new Jewelry[N];
        int[] C = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewel[i] = new Jewelry(m,v);
        }

        Arrays.sort(jewel, ((o1, o2) -> {
            //if(o1.m==o2.m) return o2.v-o1.v;
            return o1.m-o2.m;
        }));

        for (int i = 0; i <K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int j=0;
        for (int i =0; i < K; i++) {
                while (j<N && C[i] >= jewel[j].m) {
                    q.add(jewel[j].v);
                    j++;
                }
            if (!q.isEmpty())
                sum += q.poll();
        }
        System.out.println(sum);
    }
}
