import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //1. 정렬
        Arrays.sort(people);
        
        //2. 시작 인덱스 0 으로 정의
        int idx = 0;
        //3. 뒤에서 부터 시작. 합이 limit보다 작거나 같으면 idx를 증가시키고 answer를 증가시킨다.
        for(int i = people.length-1; i >= idx; i--) {
            if(people[idx] + people[i] <= limit) {
                idx++;
                answer++;
            }
            //4. 아니라면 answer만 증가시킨다.
            else 
                answer++;
        }
        return answer;
    }
}