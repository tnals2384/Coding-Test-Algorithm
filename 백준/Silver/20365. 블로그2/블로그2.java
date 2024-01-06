import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String color = br.readLine();

        int blue = 0;
        int red = 0;
        char bf='0';
        
        //바로전거와 같지 않다면 ++ 하도록
        for (int i = 0; i < N; i++) {
            char c = color.charAt(i);
            if(c!=bf) {
                if (c == 'R') red++;
                else blue++;
            }
            bf=c;
        }
        //더작은거에 1더하기
        System.out.println(Math.min(red, blue) + 1);
    }
}

