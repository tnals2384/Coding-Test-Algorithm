import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            sb.append(stack.isEmpty() ? 0 : stack.peek()).append(" ");
            stack.push(i);
        }

        System.out.println(sb);
    }
}
