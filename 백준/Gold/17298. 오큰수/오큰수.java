import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();

        //스택에 인덱스를 저장함
        stack.push(0);
        for(int i= 1;i<N;i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<N;i++)
            bw.write(ans[i]+ " ");

        br.close();
        bw.flush();
    }
}
