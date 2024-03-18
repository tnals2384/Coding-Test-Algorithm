import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        radixSort(A, 5);

        for(int i=0;i<N;i++)
            bw.write(A[i] + "\n");

        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] A, int max_size) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;

        //최대 허용되는 값이 10000이기 때문에 count가 5가 되면 종료함
        while (count != max_size) {
            int[] bucket = new int[10];

            //자릿수에 해당하는 버킷 증가시키기
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / jarisu) % 10]++;
            }
            
            //합배열을 통해 인덱스를 계산하기
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            //현재 자리수를 기준으로 output에 정렬하기
            for (int i = A.length - 1; i >= 0; i--) {
                output[bucket[(A[i] / jarisu) % 10] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }

            //정렬 데이터를 저장하기
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }
            //자릿수 증가시키기
            jarisu *= 10;
            count++;
        }
    }
}
