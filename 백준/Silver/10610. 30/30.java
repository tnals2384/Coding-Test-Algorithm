import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        int[] num = new int[N.length()];
        boolean zero=false;
        int sum=0;

        for(int i=0;i<N.length();i++) {
            num[i]= Integer.parseInt(N.charAt(i)+"");
            sum+=num[i];

            if(num[i]==0) {
                zero=true;
            }
        }

        if(!zero || sum%3!=0)
            System.out.println(-1);
        else {
            String max="";
            Arrays.sort(num);
            for(int i=N.length()-1;i>=0;i--) {
                max += Integer.toString(num[i]);
            }
            System.out.println(max);
        }
    }
}
