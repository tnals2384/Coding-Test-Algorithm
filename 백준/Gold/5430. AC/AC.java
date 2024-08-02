import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Main {
    static Deque<String> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();

            if (N == 0) deque = new ArrayDeque<>();
            else {
                String[] x = s.substring(1, s.length() - 1).split(",");
                deque = new ArrayDeque<>(Arrays.asList(x));
            }

            boolean end = false;
            boolean error = false;

            int i = 0;
            while (i < p.length()) {
                if (p.charAt(i) == 'R') {
                    end = !end;
                }
                else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (end) deque.pollLast();
                    else deque.pollFirst();
                }
                i++;
            }
            if (error) System.out.println("error");
            else System.out.println(makeAnswer(end));


        }
    }

    public static String makeAnswer(boolean end) {
        StringBuilder sb = new StringBuilder("[");

        if (end) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
