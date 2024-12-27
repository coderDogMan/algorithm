package lqb.easy;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
*我们计从 1949 年 10 月 1 日至 1949 年 10 月 2 日为经过了 1 天。
　　请问从 1949 年 10 月 1 日至 2022 年 1 月 1 日经过了多少天？
*
* */
public class GetDayNum {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse("1949-10-1");
        Date date2 = format.parse("2022-1-1");
        /*Calendar time1 = Calendar.getInstance();
        time1.setTime(date1);
        Calendar time2 = Calendar.getInstance();
        time1.setTime(date2);*/
        System.out.println((date2.getTime() - date1.getTime()) / 1000 / 60 / 60 / 24);



    }
}
