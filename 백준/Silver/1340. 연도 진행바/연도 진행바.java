import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Month;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String month=st.nextToken();
        int mon=Month.valueOf(month.toUpperCase()).getValue();
        int day=Integer.parseInt(st.nextToken().substring(0,2));
        int year=Integer.parseInt(st.nextToken());
        boolean leap=false;

        String time=st.nextToken();
        int count=0;

        //윤년계산
        if(year%4==0) {
            if(year%400!=0 && year%10==0) {
            }
            else {
                leap=true;
            }
        }

        //총날짜
        for(int i=1;i<mon;i++) {
            count+=Month.of(i).length(leap);
        }
        count+=day-1;

        //분으로 계산하여 퍼센트구하기
        int hour=Integer.parseInt(time.substring(0,2));
        int min=Integer.parseInt(time.substring(3,5));
        double percent=((double)(count*24*60 + hour*60 + min) / (double)((leap ? 366:365)*24*60))*100;
        System.out.println(percent);
    }
}
