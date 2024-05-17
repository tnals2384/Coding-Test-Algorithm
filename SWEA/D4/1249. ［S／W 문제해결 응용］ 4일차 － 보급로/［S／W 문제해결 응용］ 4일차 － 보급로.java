import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visited;
	static int[][] map;
	
	public static class Pair {
		int x;
		int y;
		int w;
		
		public Pair(int x , int y , int w) {
			this.x= x;
			this.y= y;
			this.w=w;
		}
		

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1;test_case <=T;test_case++) {
			
			int N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				String[] line = sc.next().split("");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			PriorityQueue<Pair> queue = new PriorityQueue<Pair>((o1,o2) -> o1.w-o2.w);			
			queue.add(new Pair(0,0,0));
			visited[0][0] = true;
			int answer = Integer.MAX_VALUE;
			while(!queue.isEmpty()) {
				Pair now = queue.poll();
				
				if(now.x == N-1 && now.y == N-1) {
					answer = now.w;
					break;
				}
				
				for(int i=0;i<4;i++) {
					int x = now.x + dx[i];
					int y = now.y + dy[i];
					
					if(x < 0 || x>=N || y < 0 || y >=N || visited[x][y])
						continue;
					visited[x][y] = true;
					queue.add(new Pair(x,y,now.w+map[x][y]));
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
		
	}

}
