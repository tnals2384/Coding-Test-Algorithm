import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N =sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            queue.add(sc.nextInt());
        }

        int max=0;
        for(int i=0;i<N-1;i++) {
            int sum=queue.poll()+queue.poll();
            queue.add(sum);
            max+=sum;
        }
        System.out.println(max);
    }
}
