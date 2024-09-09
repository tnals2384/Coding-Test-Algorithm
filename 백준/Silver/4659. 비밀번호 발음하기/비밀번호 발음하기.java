import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("end")) {
            boolean c1 = isVowel(s.charAt(0));
            boolean c2 = true;
            boolean c3 = true;

            int count = 1;
            boolean before = isVowel(s.charAt(0));

            for (int i = 1; i < s.length(); i++) {
                boolean isVowel = isVowel(s.charAt(i));

                //조건 1 체크
                if(!c1) {
                    if (isVowel) c1 = true;
                }

                //조건 2 체크
                if(c2) {
                    if (isVowel == before) {
                        count++;
                        if (count >= 3) {
                            c2 = false;
                        }
                    } else {
                        count = 1;
                        before = !before;
                    }
                }

                //조건 3 체크
                if(c3) {
                    if (s.charAt(i - 1) == s.charAt(i)) {
                        if (s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                            c3 = false;
                        }
                    }
                }
            }

            if ((c1 && c2 && c3)) {
                System.out.println("<" + s + ">" + " is acceptable.");
            } else {
                System.out.println("<" + s + ">" + " is not acceptable.");
            }
        }
    }

    public static boolean isVowel(char c) {
        for (char v : vowels) {
            if (c == v) {
                return true;
            }
        }
        return false;
    }
}
