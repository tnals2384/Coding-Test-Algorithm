import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static class Edge {
		int a;
		int b;
		int w;
		
		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}
	static int[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1;test_case <=T;test_case++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			A = new int[V+1];
			
			for(int i=1;i<=V;i++) {
				A[i] = i;
			}
			
			PriorityQueue<Edge> queue = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
			
			for(int i = 0;i<E;i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				int C = sc.nextInt();
				queue.add(new Edge(A,B,C));
			}
			
			int count = 0;
			long sum = 0;
			while(count < V-1) {
				Edge edge = queue.poll();
				
				if(find(edge.a) != find(edge.b)) {
					union(edge.a, edge.b);
					count++;
					sum+=edge.w;
				}
			}
			
			System.out.println("#"+test_case+" " + sum);
		}
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b)
			A[b] = a;
	}
	
	
	public static int find(int X) {
		if(X == A[X]) 
			return X;
		else 
			return A[X] = find(A[X]);
	}
}
