import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S=sc.next();
        int count=0;
        int answer;
        for(int i=1;i<S.length();i++) {
            if(S.charAt(i-1)!=S.charAt(i))
                count++;
        }
        if(count==0) answer=0;
        else answer=(count+1)/2;

        System.out.println(answer);
    }
}
