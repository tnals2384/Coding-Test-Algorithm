import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(s[i]);

        List<Integer> lis = new ArrayList<>();
        for(int value : A) {

            if(lis.isEmpty() || lis.get(lis.size()-1) < value) {
                lis.add(value);
                continue;
            }

            int lo = 0;
            int hi = lis.size()-1;

            //list에 들어갈 알맞은 index 찾기
            while(lo <= hi) {
                int mid = (lo + hi) / 2;
                if (value > lis.get(mid)) {
                    lo = mid + 1;
                }
                else hi = mid - 1;
            }

            // 원래 그 index에 있던 거랑 바꿔치기
            lis.set(lo, value);
        }

        System.out.println(lis.size());
    }
}
