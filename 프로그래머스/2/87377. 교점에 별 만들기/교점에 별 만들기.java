import java.util.*;

class Solution {
    public class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        List<Point> star = new ArrayList<>();
        long minx = Long.MAX_VALUE;
        long miny = Long.MAX_VALUE;
        long maxx = Long.MIN_VALUE;
        long maxy = Long.MIN_VALUE;

        // 교점 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long denominator = a * d - b * c;
                if (denominator == 0) continue;

                long xNumerator = b * f - e * d;
                long yNumerator = e * c - a * f;

                // 교점이 정수인지 확인
                if (xNumerator % denominator == 0 && yNumerator % denominator == 0) {
                    long x = xNumerator / denominator;
                    long y = yNumerator / denominator;
                    star.add(new Point(x, y));
                    minx = Math.min(minx, x);
                    miny = Math.min(miny, y);
                    maxx = Math.max(maxx, x);
                    maxy = Math.max(maxy, y);
                }
            }
        }

        // 맵 크기 계산
        int xlength = (int) (maxx - minx + 1);
        int ylength = (int) (maxy - miny + 1);

        // 맵 초기화
        char[][] map = new char[ylength][xlength];
        for (int i = 0; i < ylength; i++) {
            Arrays.fill(map[i], '.');
        }

        // 별 위치 찍기
        for (Point p : star) {
            map[(int) (maxy - p.y)][(int) (p.x - minx)] = '*';
        }

        // 결과 배열 변환
        String[] answer = new String[ylength];
        for (int i = 0; i < ylength; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}
