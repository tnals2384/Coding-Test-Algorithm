import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static ArrayList<String> vowel = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
    static ArrayList<String> answer = new ArrayList<>();
    static String[] arr;
    static boolean[] visited;
    static int L;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] LC = br.readLine().split(" ");
        L = Integer.parseInt(LC[0]);
        C = Integer.parseInt(LC[1]);
        arr = br.readLine().split(" ");

        visited = new boolean[C];
        Arrays.sort(arr);

        comb(0, 0, "", 0);

        for (String str : answer)
            System.out.println(str);

    }

    public static void comb(int d, int cnt, String str, int cntV) {
        if (cnt == L) {
            if (cntV >= 1 && cntV <= L - 2)
                answer.add(str);
            return;
        }

        for (int i = d; i < C; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int v = cntV;
            if (vowel.contains(arr[i]))
                v += 1;
            comb(i + 1, cnt + 1, str + arr[i], v);
            visited[i] = false;
        }
    }
}
