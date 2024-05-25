import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main  {
    static int[] home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        //1. 정렬
        Arrays.sort(home);
       
        int min = 1; //가능한 최소 거리
        int max = home[N-1]-home[0]+1; //가능한 최대 거리
        
        //2. 이분 탐색
        while(min < max) {
            int mid =  (min + max) / 2;
            if(check(mid) < C) {
                max = mid;
            }
            else
                min = mid + 1;
        }
        //최소 거리 중 가장 큰 값을 반환
        System.out.println(min-1);
    }

    //집과 집 사이 거리가 최소거리 d 일 때 놓을 수 있는 공유기의 개수를 반환
    public static int check(int d) {
        int count = 1; //첫번째 집에 무조건 놓는다
        int now = home[0];
        for(int i=1;i<home.length;i++) {
            if(home[i]-now >= d) {
                count++;
                now = home[i];
            }
        }
        return count;
    }
}
