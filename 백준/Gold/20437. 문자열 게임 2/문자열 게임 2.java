import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            game(W, K);
        }
    }

    public static void game(String W, int K) {
        //1. 어떤 문자를 K개 포함하는 가장 짧은 연속 문자열
        //2. 어떤 문자를 K개 포함하고, 첫번째와 마지막이 그 문자와 같은 가장 긴 연속 문자열의 길이
        ArrayList<Integer>[] alphabet = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = new ArrayList<>();
        }

        for (int i = 0; i < W.length(); i++) {
            alphabet[(W.charAt(i) - 'a')].add(i);
        }

        int min = W.length();
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i].size() < K) continue;

            for (int j = 0; j <= alphabet[i].size() - K; j++) {
                int now = alphabet[i].get(j + K - 1) - alphabet[i].get(j) + 1;
                min = Math.min(min, now);
                max = Math.max(max, now);
            }
        }

        if (max == -1) System.out.println(-1);
        else System.out.println(min + " " + max);
    }
}

