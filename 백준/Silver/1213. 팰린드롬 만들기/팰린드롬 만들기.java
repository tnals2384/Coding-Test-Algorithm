import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        char[] alphabet=new char[26];
        String name= br.readLine();
        String answer="";
        String center="";

        
        for(int i=0;i<name.length();i++) {
            alphabet[name.charAt(i)-65]++;
        }

        for(int i=0;i<26;i++) {

            if(alphabet[i]!=0 && alphabet[i]%2!=0) {
                if(center!="") {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                center += (char)(i+65);
            }


            for(int j=0;j<alphabet[i]/2;j++)
                answer+=(char)(i+65);

        }

        StringBuffer sb = new StringBuffer(answer);
        String reverse = sb.reverse().toString();

        answer+=center+reverse;

        System.out.println(answer);
    }
}
