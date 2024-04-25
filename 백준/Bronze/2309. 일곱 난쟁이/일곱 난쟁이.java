import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int[] A= new int[9];
    static int[] answer = new int[7] ;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++)
            A[i]= sc.nextInt();

        //조합을 다 구하기
        Arrays.sort(A);
        comb(0,0,0);

    }


    public static void comb(int sum, int s, int count) {
        if(flag) return;
        if(count==7) {
            if(sum==100) {
                flag=true;
                for (int i = 0; i < 7; i++) {
                    System.out.println(answer[i]);
                }
            }
            return;
        }

        for(int i=s;i<9;i++) {
            answer[count]= A[i];
            comb(sum + A[i], i+1, count+1);
        }

    }
}
