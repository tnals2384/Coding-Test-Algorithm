import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.next();

        int answer=0;
 
        for(int i=0;i<st.length();i++) {
            int x = st.charAt(i)-'A';
            
            if(15 <= x && 18 >= x)
                answer+=8;
            else if (19 <= x && 21 >= x)
                    answer+=9;
            else if (x >= 22)
                answer+=10;
            else {
                if(x==0) x=1;
                answer+= 3 + x/3;
            }
        }
        
        System.out.println(answer);
    }
}
