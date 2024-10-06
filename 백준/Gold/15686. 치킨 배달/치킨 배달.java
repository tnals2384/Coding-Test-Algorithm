import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /**
     * N*N 도시
     * (r,c)
     * 치킨 거리는 집과 가장 가까운  치킨집 사이 거리
     * 도시의 치킨 거리는 모든 집의 치킨 거리의 합
     * |r1-r2| + |c1-c2| = 치킨거리
     * <p>
     * 0은 빈칸, 1은 집, 2는 치킨 집
     * 가장 수익을 많이 낼 수 있는 치킨집의 개수가 최대 M개
     * 나머지는 폐업
     * 도시의 치킨 거리가 가장 작게 되어야함
     * M < 치킨집 개수 <13
     * 1 <= 집 개수 <= 2N
     * 도시의 치킨거리의 최솟값
     */
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int findDistance(Point p) {
            return  Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    public static int[][] dosi;
    public static ArrayList<Point> chicken;
    public static ArrayList<Point> house;

    public static int N, M;
    public static int min;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    house.add(new Point(j, i));
                } else if (n == 2) {
                    chicken.add(new Point(j, i));
                }
            }
        }

        //거리 계산해두기
        dosi = new int[house.size()][chicken.size()];
        for (int i = 0; i < house.size(); i++) {
            for (int j = 0; j < chicken.size(); j++) {
                dosi[i][j] = house.get(i).findDistance(chicken.get(j));
            }
        }

        min = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        comb(0,0);

        System.out.println(min);
    }

    public static void comb(int d, int curIdx) {

        if (d == M) {
            //최소 치킨 거리 합 구하기
            ArrayList<Integer> pick = new ArrayList<>();
            for (int i = 0; i < chicken.size(); i++) {
                if (visited[i]) {
                    pick.add(i);
                }
            }

            min = Math.min(min, find(pick));
            return;
        }

        //M개 뽑기
        for (int i = curIdx; i < chicken.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            comb(d + 1, i+1);
            visited[i] = false;
        }
    }

    public static int find(List<Integer> pick) {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int d = Integer.MAX_VALUE;
            for (Integer idx : pick) {
                d = Math.min(dosi[i][idx], d);
            }
            sum += d;
        }

        return sum;
    }
}
