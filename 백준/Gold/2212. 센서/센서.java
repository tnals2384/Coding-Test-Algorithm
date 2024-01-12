import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        List<Integer> sensor = new ArrayList<>();
        int[] minus = new int[N-1];
        int count=0;
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(st.nextToken());
            //중복을 제거해야함
            if (sensor.contains(x))
                    continue;
            sensor.add(x);
        }

        //정렬 후 거리 차 구하기
        Collections.sort(sensor);
        for (int i=1;i<sensor.size();i++) {
            minus[i-1]=sensor.get(i) - sensor.get(i-1);
        }

        //거리차를 정렬 한 후, K-1개의 큰 값을 빼고 더함
        Arrays.sort(minus);
        for (int i=0; i<minus.length-(K-1);i++)
            count+=minus[i];


        System.out.println(count);
    }
}
