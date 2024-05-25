import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        String[] list = br.readLine().split(" ");

        Arrays.sort(list, (o1,o2)-> {
            String num1 = o1 + o2;
            String num2 = o2 + o1;
            return num2.compareTo(num1);
        });

        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for (int i=0;i<list.length;i++) {
            if(!list[i].equals("0"))
                zero=false;
            sb.append(list[i]);
        }
        if(zero)
            System.out.println(0);
        else System.out.println(sb);

    }
}
