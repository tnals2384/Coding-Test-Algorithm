import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] blue = new boolean[6][4];
    static boolean[][] green = new boolean[6][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int t = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);

            if (t == 1) {
                add1x1Block(x, y);
            } else if (t == 2) {
                add1x2Block(x, y);
            } else {
                add2x1Block(x, y);
            }

            //한 열, 한 행이 1인게 있는 지를 검사하고 당겨주기
            checkFullAndShift(blue);
            checkFullAndShift(green);

            //4,5번 행에 있는 경우 당겨주기
            move(blue);
            move(green);
        }

        System.out.println(count);
        System.out.println(countTile());
    }

    private static void add1x1Block(int x, int y) {
        for (int i = 0; i < 6; i++) {
            if (i == 5 || green[i + 1][y]) {
                green[i][y] = true;
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (i == 5 || blue[i + 1][x]) {
                blue[i][x] = true;
                break;
            }
        }
    }

    private static void add1x2Block(int x, int y) {
        for (int i = 0; i < 6; i++) {
            if (i == 5 || y + 1 >= 4 || green[i + 1][y] || green[i + 1][y + 1]) {
                green[i][y] = true;
                green[i][y + 1] = true;
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (i == 5 || blue[i + 1][x]) {
                blue[i - 1][x] = true;
                blue[i][x] = true;
                break;
            }
        }
    }

    private static void add2x1Block(int x, int y) {
        for (int i = 0; i < 6; i++) {
            if (i == 5 || x + 1 >= 4 || blue[i + 1][x] || blue[i + 1][x + 1]) {
                blue[i][x] = true;
                blue[i][x + 1] = true;
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (i == 5 || green[i + 1][y]) {
                green[i - 1][y] = true;
                green[i][y] = true;
                break;
            }
        }
    }

    private static int countTile() {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (green[i][j]) sum++;
                if (blue[i][j]) sum++;
            }
        }
        return sum;
    }

    static int count = 0;

    private static void checkFullAndShift(boolean[][] A) {
        int check = 0;
        for (int i = 5; i >= 0; i--) {
            if (A[i][0] && A[i][1] && A[i][2] && A[i][3]) {
                check++;
                if (i > 0 && A[i - 1][0] && A[i - 1][1] && A[i - 1][2] && A[i - 1][3])
                    check++;
            }

            if (check == 0) continue;

            count += check;
            shift(i, check, A);
            break;
        }
    }

    private static void shift(int idx, int check, boolean[][] A) {
        for (int i = idx; i > check - 1; i--) {
            for (int j = 0; j < 4; j++) {
                A[i][j] = A[i - check][j];
            }
        }
    }
    
    private static void move(boolean[][] A) {
        int check = 0;
        for (int i = 0; i < 4; i++) {
            if (A[0][i]) {
                check = 2;
                break;
            }
            if (A[1][i]) check = 1;
        }

        if (check == 0) return;

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (i <= 1) A[i][j] = false;
                else A[i][j] = A[i - check][j];
            }
        }
    }
}
