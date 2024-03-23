import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zero = 0;
        int one = 0;
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x < 0)
                minus.add(x);
            else if (x == 0)
                zero++;
            else if (x == 1)
                one++;
            else plus.add(x);
        }

        int ans = 0;

        //큰 음수끼리 곱
        while (minus.size() > 1)
            ans += (minus.poll() * minus.poll());

        //0이 없으면 남은 음수를 더해주고, 0이 있으면 더하지 않음
        if (zero == 0 && !minus.isEmpty())
            ans += minus.poll();

        //큰 양수끼리 곱
        while (plus.size() > 1)
            ans += (plus.poll() * plus.poll());

        //남은 양수는 더해주기
        if (!plus.isEmpty())
            ans += plus.poll();

        //남은 1 더해주기
        System.out.println(ans + one);
    }
}
