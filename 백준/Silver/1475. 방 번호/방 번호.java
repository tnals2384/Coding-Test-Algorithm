import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String N = sc.next();
        int[] arr= new int[10];
        
        for(int i=0; i<N.length();i++) {
            arr[(N.charAt(i)-'0')]++;
        }
        
        while(abs(arr[6]-arr[9]) >= 2) {
            if(arr[6] < arr[9]) {
                arr[6]+=1;
                arr[9]-=1;
            }
            else {
                arr[6]-=1;
                arr[9]+=1;
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[9]);
    }
}
