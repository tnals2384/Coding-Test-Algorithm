import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static class data {
        private int idx;
        private int num;

        public data(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        data[] arr = new data[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o.num));
        int max = 0;
        //숫자의 정렬 전 idx와 정렬 후 idx를 비교하여 왼쪽으로 가장 많이 이동한 거리
        //인덱스가 1부터 시작하므로 +1

        for (int i = 0; i < N; i++) {
            if (arr[i].idx - i > max)
                max = arr[i].idx - i;
        }

        System.out.println(max + 1);
    }
}
