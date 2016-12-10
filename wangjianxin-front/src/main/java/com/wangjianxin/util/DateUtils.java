package com.wangjianxin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * Examples Using the US Locale:
 * <p/>
 * Format Pattern                         Result
 * --------------                         -------
 * "yyyy.MM.dd G 'at' hh:mm:ss z"    ->>  1996.07.10 AD at 15:08:56 PDT
 * "EEE, MMM d, ''yy"                ->>  Wed, July 10, '96
 * "h:mm a"                          ->>  12:08 PM
 * "hh 'o''clock' a, zzzz"           ->>  12 o'clock PM, Pacific Daylight Time
 * "K:mm a, z"                       ->>  0:00 PM, PST
 * "yyyyy.MMMMM.dd GGG hh:mm aaa"    ->>  1996.July.10 AD 12:08 PM
 * </pre>
 */
public class DateUtils {
    /**
     * parse a String to a java.util.Date object
     */
    public static Date parseDate(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.US);
        ParsePosition pos = new ParsePosition(0);
        Date ret = formatter.parse(date, pos);
        return ret;
    }

    /**
     * format a java.util.Date object to a String
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.US);
        String ret = formatter.format(date);
        return ret;
    }
    /**
     * format a java.util.Date object to a String
     */
    public static String formatDate1(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String ret = formatter.format(date);
        return ret;
    }

    public static long getQuot(String startDate,String endDate){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        long retrunDays = 0L;
        try {
            Date startDateTmp = sf.parse(startDate);
            Date endDateTmp = sf.parse(endDate);
            retrunDays=(endDateTmp.getTime()-startDateTmp.getTime())/(24*60*60*1000);

        } catch (ParseException e) {
            // TODO Auto-generated catch block

            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return retrunDays;

    }



    public static long getQuot(Date startDate,Date endDate){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        long retrunDays = 0L;
        try {
            //Date startDateTmp = sf.parse(startDate);
            //Date endDateTmp = sf.parse(endDate);
            retrunDays=(endDate.getTime()-startDate.getTime())/(24*60*60*1000);

        } catch (Exception e) {
            // TODO Auto-generated catch block

            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return retrunDays;

    }

    public static String getNoName(String noType)
    {
        //String[] sizeArr = size.split("x");
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = format.format(new Date());
        int random = new Random().nextInt(10000);


        //return formatDate +   random+ "_"+sizeArr[0]+"_"+sizeArr[1] +   extension ;
        return noType+"_"+formatDate +"_" +  random;

    }
    /**
     * 得到几天后的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d,int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
        return now.getTime();
    }
    

        /**
     * 得到几天后的时间
     * @param day
     * @return
     */
    public static String getDateAfter(int day){
        Calendar now =Calendar.getInstance();

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        now.setTime(date);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
        return  sf.format( now.getTime());
    }
    
}
