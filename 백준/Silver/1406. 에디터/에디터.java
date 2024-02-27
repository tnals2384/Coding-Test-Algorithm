import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> list = new LinkedList<>();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());

        ListIterator<Character> iterator = list.listIterator(str.length());

        for(int i=0;i<N;i++) {
            String line = br.readLine();
            char commend = line.charAt(0);
            if (commend=='P') {
                iterator.add(line.charAt(2));
            } else if (commend == 'L') {
                if(iterator.hasPrevious())
                    iterator.previous();
            } else if (commend == 'D') {
                if(iterator.hasNext())
                    iterator.next();
            } else {
                if(iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove(); //next나 previous에 의해 반환된 가장 마지막 요소를 삭제
                }
            }
        }
        for(Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();
    }
}

