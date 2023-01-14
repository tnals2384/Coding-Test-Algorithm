class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String[] arr =new String[t.length()-p.length()+1];
        for(int i=0 ;i<=t.length()-p.length();i++) {
            arr[i] = t.substring(i,i+p.length());
        }

        for(int i=0; i< arr.length;i++) {
            if(arr[i].compareTo(p)<1)
                answer+=1;
        }
        
        return answer;
    }
}