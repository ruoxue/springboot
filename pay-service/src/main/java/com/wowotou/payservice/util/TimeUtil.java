package com.wowotou.payservice.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public  static Calendar getCalenderByTime(long time){

        long miniTime=time*1000L;
        Date date=new Date();
        date.setTime(miniTime);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
       return  sdf.getCalendar();

    }




}
