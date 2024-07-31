import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static class Trie {
        Trie[] child;
        boolean pass;
        boolean end;
        Trie() {
            child = new Trie[10];
            pass = false;
            end = false;
        }

        public boolean insert(String str, int idx) {
            //지금까지 같은데 나보다 짧은애가 있으면 안됨
            if(end) return false;

            //나 끝났는데 나보다 더 긴애가 있으면 안됨
            if(idx == str.length()) {
                end = true;
                return !pass;
            }
            else {
                int next = str.charAt(idx)- '0';
                if(child[next] == null) {
                    child[next] = new Trie();
                }
                pass = true;
                return child[next].insert(str, idx+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());
            boolean check = true;
            Trie trie = new Trie();

            for(int i=0;i<n;i++) {
                if(check)
                    check = trie.insert(br.readLine(),0);
                else br.readLine();
            }

            if(check) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
