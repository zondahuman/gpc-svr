package com.rpc.mail.client.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by abin on 2017/8/2 18:34.
 * gpc-svr
 * com.rpc.mail.client
 */


public class GrpcClientTest {
    public static void main(String[] args) throws Exception {

        String result1 = getMonth(0);
        System.out.println("result1="+result1);
        String result2 = getMonth("2016-11-02 21:10:31");
        System.out.println("result2="+result2);
    }

    public static String getMonth(Integer which){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        //过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -which);
        Date m = c.getTime();
        String mon = format.format(m);
        System.out.println("过去一个月："+mon);
        return mon;
    }

    public static String getMonth(String which) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = format.parse(which);
        String month = format.format(date);
        return month;
    }

}