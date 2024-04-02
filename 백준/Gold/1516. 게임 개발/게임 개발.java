import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        int[] time = new int[N + 1];
        int[] D = new int[N + 1]; //진입차수 배열

        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1)
                    break;
                //인접 리스트에 저장
                A[x].add(i);
                //진입차수 count
                D[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[N + 1];

        //진입차수 0인것부터 시작
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int idx : A[now]) {
                D[idx]--;
                //건물을 동시에 지을 수 있기 때문에, 이전에 지어야하는 건물들 중 가장 오래걸리는 건물 생성 시간으로 업데이트 해줘야함
                answer[idx] = Math.max(answer[idx], answer[now] + time[now]);

                if (D[idx] == 0)
                    queue.add(idx);
            }
        }

        for (int i = 1; i <= N; i++)
            System.out.println(answer[i] + time[i]);
    }
}
