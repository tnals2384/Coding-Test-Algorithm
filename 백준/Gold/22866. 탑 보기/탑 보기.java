import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static class Node {
        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int[] A = new int[N + 1];
        for (int i = 0; i < N; i++) {
            A[i + 1] = Integer.parseInt(s[i]);
        }

        Stack<Node> stack = new Stack<>();
        Node[][] answer = new Node[2][N + 1];
        for (int i = 1; i <= N; i++) {
            int idx = -1;
            while (!stack.isEmpty() && stack.peek().num <= A[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) idx = stack.peek().idx;
            int count = stack.size();
            answer[0][i] = new Node(idx, count);

            stack.add(new Node(i, A[i]));
        }

        stack = new Stack<>();
        for (int i = N; i > 0; i--) {
            int idx = -1;
            while (!stack.isEmpty() && stack.peek().num <= A[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) idx = stack.peek().idx;
            int count = stack.size();
            answer[1][i] = new Node(idx, count);
            stack.add(new Node(i, A[i]));
        }

        for (int i = 1; i <= N; i++) {
            int count = answer[0][i].num + answer[1][i].num;
            if(count == 0) System.out.println(0);
            else {
                System.out.print(count + " ");
                if(answer[0][i].idx < 0) System.out.println(answer[1][i].idx);
                else if(answer[1][i].idx < 0) System.out.println(answer[0][i].idx);
                else {
                    if(Math.abs(i-answer[0][i].idx) <= Math.abs(i-answer[1][i].idx)) {
                        System.out.println(answer[0][i].idx);
                    }
                    else System.out.println(answer[1][i].idx);
                }
            }
        }

  
    }
}
