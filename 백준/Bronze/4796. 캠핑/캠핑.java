import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int i=1;
        while(true) {
            int L=sc.nextInt();
            if(L==0) break;
            int P=sc.nextInt();
            int V=sc.nextInt();

            int max=0;
            max+=(V/P)*L;

            if(V%P<L)
                max+=V%P;
            else max+=L;


            System.out.println("Case "+i+": "+max);
            i++;
        }
    }
}
