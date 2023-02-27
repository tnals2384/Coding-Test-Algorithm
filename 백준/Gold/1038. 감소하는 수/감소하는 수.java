import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt();
        //N번째 감소하는 수를 출력
        //N은 1,000,000 보다 작거나 같은 자연수

        if(N<=10)
            System.out.println(N);
        else if(N>1022)
            System.out.println(-1);
        else {
            for (int i = 0; i < 10; i++) {
                check(i,1);
            }

            //정렬!!
            Collections.sort(list);

            System.out.println(list.get(N));
        }
    }

    private static void check(long num,int idx) {
        //정수 범위는 2,147,483,647 으로 10자리를 벗어나면 안됨
        if(idx>10)
            return;


        list.add(num);
        //num%10 한 것보다 작은 것만 뒤에 붙을 수 있음
        for(int i=0;i<num%10;i++) {
            check((num*10)+i,idx+1);
        }
    }
}
