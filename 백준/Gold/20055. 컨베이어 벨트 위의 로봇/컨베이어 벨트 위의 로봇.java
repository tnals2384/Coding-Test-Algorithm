import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int[] A = new int[2 * N + 1];

        String[] a = br.readLine().split(" ");
        for (int i = 1; i <= a.length; i++) {
            A[i] = Integer.parseInt(a[i - 1]);
        }

        int start = 1;
        int end = N;
        int round = 0;
        Queue<Integer> robot = new LinkedList<>();


        boolean[] visited = new boolean[2 * N + 1];
        while (true) {
            round++;
            
            //1. 벨트가 한칸 회전
            start = start - 1 >= 1 ? start - 1 : 2 * N;
            end = end - 1 >= 1 ? end - 1 : 2 * N;
            
            //2. 이동할 수 있으면 이동
            // 이동하려는칸에 로봇이 없고, 그 칸의 내구도가 1이상 남아있어야함
            int len = robot.size();
            for (int i = 0; i < len; i++) {
                int robotIdx = robot.poll();
                int nextIdx = (robotIdx + 1) > 2*N ? 1 : robotIdx+1;

                if (robotIdx == end) {
                    visited[robotIdx] = false;
                    continue;
                }

                if (!visited[nextIdx] && A[nextIdx] >= 1) {
                    visited[robotIdx] = false;
                    A[nextIdx]--;

                    if (nextIdx != end) {
                        visited[nextIdx] = true;
                        robot.add(nextIdx);
                    }
                } else robot.add(robotIdx);
            }

            //3. 올리는 위치 칸의 내구도가 0이 아니면 올리는 위치에 올림
            if (A[start] > 0 && !visited[start]) {
                robot.add(start);
                visited[start] = true;
                A[start]--;
            }

            if (countZero(A) >= K) {
                System.out.println(round);
                break;
            }

        }
    }

    public static int countZero(int[] A) {
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == 0) count++;
        }
        return count;
    }
}
