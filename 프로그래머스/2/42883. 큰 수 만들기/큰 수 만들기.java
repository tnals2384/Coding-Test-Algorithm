class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        //총 넘버개수중에 k개를 빼야됨
        for(int i=0;i < number.length() - k;i++) {
            int max = 0;
            for(int j=index;j<=k+i;j++) {
                if(number.charAt(j) -'0' > max) {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}