import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int solution(int N) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            queue.add(i);
        }

        while(queue.size()>1) {
            queue.poll();
            queue.add(queue.poll());
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(solution(N));

    }
}
