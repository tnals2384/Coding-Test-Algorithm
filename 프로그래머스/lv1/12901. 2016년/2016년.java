class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] Day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] month={0,31,29,31,30,31,30,31,31,30,31,30,31};
        int day=0;
        for(int i=1;i<a;i++)
            day += month[i];

        day += b;

        answer=Day[day % 7];
        return answer;
    }
}