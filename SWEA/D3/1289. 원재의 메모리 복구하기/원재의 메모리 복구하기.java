import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <=T; test_case++) {
			String line = sc.next();
			int count=0;
			char check = '1';
			for(int i=0;i<line.length();i++) {
				if(line.charAt(i) == check) {
					count++;
					check = (check=='1') ? '0':'1';
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		}
	}

}
