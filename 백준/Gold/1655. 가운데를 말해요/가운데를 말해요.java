import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        PriorityQueue<Integer> max = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            //max에 먼저 추가하고 번갈아가면서 추가
            if (min.size() == max.size()) max.add(x);
            else min.add(x);

            if (!min.isEmpty() && !max.isEmpty()) {
                //min의 최솟값이 max의 최댓값보다 크다면 바꿔주는 것
                //[max][min] 이렇게 있다고 생각하면 max의 가장 뒷값과 min의 가장 앞값을 바꿔주는 것
                if (min.peek() < max.peek()) {
                    int tmp = max.poll();
                    max.add(min.poll());
                    min.add(tmp);
                }
            }
            bw.write(max.peek() + " \n");
        }
        bw.flush();

    }
}
