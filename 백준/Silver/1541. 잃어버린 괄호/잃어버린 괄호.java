import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split("-");
        int[] num= new int[token.length];
        
        for(int i=0;i<token.length;i++) {
            String[] plus = token[i].split("\\+");
            int count=0;
            
            for(int j=0;j< plus.length;j++) {
                count+=Integer.parseInt(plus[j]);
            }
            
            num[i]=count;
        }

        int min = num[0];
        for(int i=1;i<token.length;i++)
            min-=num[i];

        System.out.println(min);
    }
}
