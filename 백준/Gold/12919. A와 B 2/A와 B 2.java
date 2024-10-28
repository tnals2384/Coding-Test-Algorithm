import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 문자열 뒤에 A를 추가하거나
     * 문자열 뒤에 B를 추가하고 문자열을 뒤집음
     * S를 T로 바꿀수잇는지 없는지 알아내는 프로그램
     */
    public static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        find(S,T);
        System.out.println(check ? 1 : 0);
    }

    public static void find(String S, String T) {
        if (T.length() == S.length()) {
            if(T.equals(S)) {
                check = true;
            }
            return;
        }

        if(T.charAt(T.length()-1) == 'A')
            find(S, T.substring(0,T.length()-1));

        if(T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(T.substring(1)).reverse();
            find(S, sb.toString());
        }
    }
}
