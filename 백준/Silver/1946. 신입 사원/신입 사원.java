import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {

            int N= Integer.parseInt(br.readLine());
            int[] rank = new int[N+1];

            for(int i=1;i<=N;i++) {
                StringTokenizer st= new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
               rank[x]=y; //순위는 겹치지 않음을 이용
            }

            int count=1;
            int min=rank[1];
            for(int i=2;i<=N;i++) {
                if(min>rank[i]) { //더 작으면 count한 다음 최솟값을 바꾸어줌
                    count++;
                    min= rank[i];
                }
            }

            System.out.println(count);
        }
    }
}
