import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //quick 정렬을 구현해서 풀기
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int start, int end, int K) {
        if (start < end) {
            //pivot을 정하여 두 집합으로 분할
            int pivot = partition(A, start, end);
            
            //pivot이 K라면 더이상 정렬할 필요 없음. return
            if (pivot == K)
                return;
            //K가 pivot보다 작다면 앞부분 집합을 다시 quicksort
            else if (K < pivot) {
                quickSort(A, start, pivot - 1, K);
            } 
            //K가 pivot보다 크다면 뒷부분 집합을 다시 quicksort
            else {
                quickSort(A, pivot + 1, end, K);
            }
        }
    }

    public static int partition(int[] A, int start, int end) {
        //만약 배열 크기가 2라면 바로 비교하여 return 하기
        if (start + 1 == end) {
            if (A[start] > A[end]) {
                swap(A, start, end);
                return end;
            }
        }

        //중간 값을 pivot으로 설정
        int M = (start + end) / 2;
        //pivot을 맨 앞으로 이동
        swap(A, start, M);
        int pivot = A[start];
        
        //i,j를 설정
        int i = start + 1;
        int j = end;
        //i보다 j가 커질때까지
        while (i <= j) {
            //배열의 끝에서부터 pivot보다 작은값이 나올때까지 j를 이동
            while (pivot < A[j] && j > 0)
                j--;
            //pivot의 바로 뒤 index부터 pivot보다 큰 값이 나올 때까지 i를 이동
            while (pivot > A[i] && i < A.length - 1)
                i++;
            //두 수를 swap
            if (i <= j)
                swap(A, i++, j--);
        }
        
        // 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정
        A[start] = A[j];
        A[j] = pivot;
        return j;

    }

    public static void swap(int[] A, int start, int end) {
        int tmp = A[start];
        A[start] = A[end];
        A[end] = tmp;

    }
}
