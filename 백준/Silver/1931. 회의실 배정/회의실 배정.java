import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

     static class Time {
        int start;
        int end;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        Time[] time =new Time[N];

        for(int i=0;i < N;i++) {
            time[i] = new Time();
            time[i].start = sc.nextInt();
            time[i].end = sc.nextInt();
        }

        Arrays.sort(time, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.end==o2.end) {
                    return Integer.compare(o1.start,o2.start);
                }
                return Integer.compare(o1.end,o2.end);
            }
        });

        int endTime=time[0].end;
        int count=1;
        for(int i=1;i<N;i++) {
            if(time[i].start >= endTime) {
                endTime=time[i].end;
                count++;
            }
        }
        System.out.println(count);
     }
}