import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int L= Integer.parseInt(st.nextToken());

        Deque<Node> mydeq = new LinkedList<>();
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!mydeq.isEmpty() && mydeq.getLast().value> now) {
                mydeq.removeLast();
            }
            mydeq.addLast(new Node(now,i));
            if(mydeq.getFirst().index<=i-L)
                mydeq.removeFirst();
            bw.write(mydeq.getFirst().value+" ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int index;
        public int value;

        Node(int value, int index) {
            this.index= index;
            this.value=value;
        }
    }
}
