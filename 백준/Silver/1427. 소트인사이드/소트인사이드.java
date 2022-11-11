import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N= sc.next();
        Character[] arr = new Character[N.length()];
        for(int i=0; i<N.length();i++) {
            arr[i] = N.charAt(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<N.length();i++)
            System.out.print(arr[i]);
    }
}