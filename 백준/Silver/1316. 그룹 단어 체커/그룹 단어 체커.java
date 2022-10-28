import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        String word;
        int count=0;
        for(int i=0;i<N;i++) {
            word=sc.next();

            if(word.length()==1) {
                count++;
                continue;
            }

            int j=1;
            while(j<word.length()) {
                if(word.indexOf(word.charAt(j-1),j) != -1) {
                    if(word.charAt(j-1)!=word.charAt(j)) {
                        break;
                    }
                }
                j++;
            }
            if(j==word.length()) count++;
        }
        System.out.println(count);
    }
}