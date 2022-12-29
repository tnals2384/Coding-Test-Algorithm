import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> Q= new LinkedList<>();
        Scanner sc =new Scanner(System.in);
        int count=0;
        int N=sc.nextInt();
        int M=sc.nextInt();
        for(int i=1;i<=N;i++) {
            Q.offer(i);
        }
        int half_idx=0;

        for(int i=0;i<M;i++) {
            int num =sc.nextInt();
            int idx= Q.indexOf(num);
            if(Q.size()%2==0) {
                half_idx=Q.size()/2-1;
            }
            else {
                half_idx=Q.size()/2;
            }

            if(idx <= half_idx) {
                for(int j=0; j<idx;j++) {
                    Q.offerLast(Q.pollFirst());
                    count++;
                }
            }
            else {
                for(int j=0; j<Q.size()-idx;j++) {
                    Q.offerFirst(Q.pollLast());
                    count++;
                }
            }
            Q.pollFirst();
        }
        System.out.println(count);
    }

}