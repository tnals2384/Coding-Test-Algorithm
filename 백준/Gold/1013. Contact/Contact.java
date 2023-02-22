import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            String str=br.readLine();
            String pattern = "(100+1+|01)+";
            boolean match = Pattern.matches(pattern,str);
            if(!match)
                System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
