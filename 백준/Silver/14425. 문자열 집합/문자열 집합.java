import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static public class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        Node root = new Node();
        for(int k=0;k<N;k++) {
            String word = br.readLine();
            Node now = root;
            for(int i=0;i< word.length();i++) {
                char c = word.charAt(i);
                if(now.next[c-'a'] == null)
                    now.next[c-'a']= new Node();

                now = now.next[c-'a'];
                if(i == word.length()-1)
                    now.isEnd = true;
            }
        }

        int count=0;

        for(int k=0;k<M;k++) {
            String word = br.readLine();
            Node now = root;

            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);

                if(now.next[c-'a'] == null)
                    break;

                now = now.next[c-'a'];
                if(i == word.length()-1 && now.isEnd)
                    count++;
            }
        }
        System.out.println(count);

    }
}
