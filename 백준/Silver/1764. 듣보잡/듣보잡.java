import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        HashSet<String> listen = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();

        for(int i=0;i<N;i++)
            listen.add(br.readLine());

        for(int i=0;i<M;i++) {
            String watch = br.readLine();
            if(listen.contains(watch))
                answer.add(watch);
        }
        Collections.sort(answer);

        bw.write(answer.size()+"\n");

        for(String name:answer)
            bw.write(name+"\n");

        bw.flush();

    }
}
