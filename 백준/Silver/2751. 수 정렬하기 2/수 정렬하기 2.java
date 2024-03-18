import java.io.*;

public class Main {
    public static int[] A;
    public static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        mergeSort(0, N-1);

        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++)
            bw.write(A[i]+"\n");
        
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        int m = (s + e) / 2;

        //나눈 배열의 길이가 1보다 작으면 return
        if (e - s < 1)
            return;
        //나눌 수 있을 때까지 나누기
        mergeSort(s, m);
        mergeSort(m + 1, e);


        //tmp에 기존 배열 저장
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        //한쪽 그룹이 모두 선택될 때까지
        while (index1 <= m && index2 <= e) {

            if (tmp[index1] < tmp[index2]) {
                A[k] = tmp[index1];
                k++;
                index1++;
            } else {
                A[k] = tmp[index2];
                k++;
                index2++;
            }
        }

        //남아있는 값 정리하기
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
