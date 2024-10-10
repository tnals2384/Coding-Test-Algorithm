import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
     * 4*4 크기의 공간
     * 각 칸은 (x,y)로 표현
     * 번호와 방향을 갖고 있음 1~16 , 방향은 8가지
     *상어의 방향은 0,0물고기의 방향 0,0을 먹고 시작함
     * 상어가먹고 -> 물고기 이동
     * 상어는 0으로 갈 수 없음, 그방향으로 의 모든 칸으로는 이동 가능
     * 물고기는 1칸 이동 가능하고, 서로 위치가 바뀜
     * 물고기는 방향이 이동할 수  있는 칸을 향할 때까지 45도 반시계 회전
     * 이동할수 없으면 이동하지 않음
     * 상어가 이동할 수 있는 칸이 없으면 끝!
     */

    public static class Fish {
        int idx;
        int dir;

        public Fish(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }

    public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[][] place = new Fish[4][4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                Fish fish = new Fish(idx, dir - 1);
                place[i][j] = fish;
            }
        }

        Fish firstFish = place[0][0];
        int sharkDir = firstFish.dir;
        place[0][0] = null;
        find(place, 0, 0, sharkDir, firstFish.idx);

        System.out.println(max);

    }

    public static void find(Fish[][] place, int x, int y, int dir, int sum) {
        max = Math.max(sum, max);
        //물고기가 이동하기
        Fish[][] copyPlace = copyPlace(place);
        move(copyPlace, x, y);

        for (int i = 1; i < 4; i++) {
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || copyPlace[ny][nx] == null) continue;

            Fish now = copyPlace[ny][nx];
            copyPlace[ny][nx] = null;
            find(copyPlace, nx, ny, now.dir, sum + now.idx);
            copyPlace[ny][nx] = now;
        }
    }

    public static void move(Fish[][] place, int sx, int sy) {

        for (int i = 1; i <= 16; i++) {
            fishMove(place, i, sx, sy);
        }
    }

    public static void fishMove(Fish[][] place, int idx, int sx, int sy) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Fish fish = place[i][j];
                if (fish != null && fish.idx == idx) {
                    for (int d = fish.dir; d < fish.dir + 8; d++) {
                        int nx = j + dx[d % 8];
                        int ny = i + dy[d % 8];

                        if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == sx && ny == sy)) continue;

                        Fish temp = place[ny][nx];
                        place[ny][nx] = new Fish(fish.idx, d % 8);
                        place[i][j] = temp != null ? new Fish(temp.idx, temp.dir) : null;
                        return;
                    }
                }
            }
        }

    }

    public static Fish[][] copyPlace(Fish[][] place) {
        Fish[][] newPlace = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newPlace[i][j] = place[i][j] == null ? null : place[i][j];
            }
        }
        return newPlace;
    }
}
