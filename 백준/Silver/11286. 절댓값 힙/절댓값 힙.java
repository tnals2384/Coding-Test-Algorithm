import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->
        {
            int x = Math.abs(o1);
            int y = Math.abs(o2);

            if(x == y)
                return o1 > o2 ? 1: -1; //절댓값이 같을 경우 음수를 앞에
            else return x - y; //절댓값을 기준으로 작은 것 부터 정렬 
            /*음수로 리턴을 하면 작은것부터 정렬이됨! 양수로 리턴하면 큰것부터 정렬*/
        });

        for(int i=0;i<N;i++) {
            int x = sc.nextInt();
            if(x==0) {
                if (queue.isEmpty())
                    System.out.println(0);
                else System.out.println(queue.poll());
            }
            else
                queue.add(x);
        }
    }
}
