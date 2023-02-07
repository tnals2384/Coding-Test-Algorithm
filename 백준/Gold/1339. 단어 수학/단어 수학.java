import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] count=new int[26];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            int len= str.length();
            for(int j=0;j<len;j++) {
                count[(int)str.charAt(j)-65]+=Math.pow(10,len-1-j);
            }
        }
        
        Arrays.sort(count);

        int sum=0;
        int x=9;
        for(int i=0;i<10;i++) {
            sum+=count[25-i]*x;
            x--;
        }

        System.out.println(sum);
    }
}
