import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //먼저 -로 split
        String[] token = br.readLine().split("-");
        int[] list = new int[token.length];

        for(int i=0;i<token.length;i++) {
            //plus로 split 후 더할 수 있는 건 다 더해서 list에 저장
            String[] plus = token[i].split("\\+");
            int num=0;
            for(int j=0;j<plus.length;j++) {
                num += Integer.parseInt(plus[j]);
            }
            list[i]=num;
        }

        //list에 있는 수는 다 빼기
        int ans=list[0];
        for (int i=1;i<list.length;i++) {
            ans-=list[i];
        }

        System.out.println(ans);
    }
}

