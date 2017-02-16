/**
 *
 */
package com.hwm.unicom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author hanbin
 */
public class TimeTools {
    static private String GetTimeStrFromMimS(String mims, String formatstr) {
        long longtime = Long.parseLong(mims);
        SimpleDateFormat format = new SimpleDateFormat(formatstr);
        return format.format(longtime * 1000);
    }

    static public String GetTimeStrFromMimSYMD(String mims) {
        String retString = GetTimeStrFromMimS(mims, "yyyy-MM-dd");
        return retString;
    }

    static public int GetCurHour() {

        SimpleDateFormat format = new SimpleDateFormat("HH");
        return Integer.parseInt(format.format(System.currentTimeMillis()));
    }

    static public String GetTimeStrFromMimS(String mims) {
        long longtime = Long.parseLong(mims);
        SimpleDateFormat format = new SimpleDateFormat();
        return format.format(longtime);
    }

    static public String GetWeekDay(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("EEEE");
        return sdf.format(millis * 1000);
    }

    public static String getDateStr(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyy年MM月dd日");
        return sdf.format(millis * 1000);
    }

    public static String getDateLong(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyyMMdd");
        return sdf.format(millis);
    }

    /**
     * 根据long类型获取月日
     * @param millis long类型日期
     * @return 09-11
     */
    public static String getMonthDayLong(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("MM-dd");
        return sdf.format(millis);
    }

    public static String getDateCompleteStr(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyyMMddHHmm");
        return sdf.format(millis);
    }

    public static String getDateDayStr(long millis) {
        // Calendar cal = Calendar.getInstance();
        // cal.setTimeInMillis(millis);
        // Formatter ft = new Formatter(Locale.CHINA);
        // return ft.format("%1$tm��%1$td��  %1$tM", cal).toString();
        // return ft.format("%1$tY��%1$tm��%1$td��", cal).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("MM月dd日");
        return sdf.format(millis * 1000);
    }

    /**
     * 转换成yyyy-MM-dd
     * @param millis
     * @return
     */
    public static String getDateDayStrs(long millis) {
        // Calendar cal = Calendar.getInstance();
        // cal.setTimeInMillis(millis);
        // Formatter ft = new Formatter(Locale.CHINA);
        // return ft.format("%1$tm��%1$td��  %1$tM", cal).toString();
        // return ft.format("%1$tY��%1$tm��%1$td��", cal).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyy-MM-dd");
        return sdf.format(millis);
    }

    public static String getDateDayCurrStr(long millis) {
        // Calendar cal = Calendar.getInstance();
        // cal.setTimeInMillis(millis);
        // Formatter ft = new Formatter(Locale.CHINA);
        // return ft.format("%1$tm��%1$td��  %1$tM", cal).toString();
        // return ft.format("%1$tY��%1$tm��%1$td��", cal).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("MM月dd日");
        return sdf.format(millis);
    }

    public static String getDateDayCurrTimeStr(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("dd/MM/yyyy");
        return sdf.format(millis);
    }

    //把字符串转为日期
    public static Date converToDate(String strDate) throws Exception
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(strDate);
    }

    public static String getDateDayTimeStr(long millis) {
        // Calendar cal = Calendar.getInstance();
        // cal.setTimeInMillis(millis);
        // Formatter ft = new Formatter(Locale.CHINA);
        // return ft.format("%1$tm��%1$td��  %1$tM", cal).toString();
        // return ft.format("%1$tY��%1$tm��%1$td��", cal).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyyMMdd");
        return sdf.format(millis);
    }

    public static String getDateAllStr(long millis) {
        // Calendar cal = Calendar.getInstance();
        // cal.setTimeInMillis(millis);
        // Formatter ft = new Formatter(Locale.CHINA);
        // return ft.format("%1$tm��%1$td��  %1$tM", cal).toString();
        // return ft.format("%1$tY��%1$tm��%1$td��", cal).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(millis * 1000);
    }

    public static String getDateTimeStr(long millis) {
        // Calendar cal = Calendar.getInstance();
        // cal.setTimeInMillis(millis);
        // Formatter ft = new Formatter(Locale.CHINA);
        // return ft.format("%1$tm��%1$td��  %1$tM", cal).toString();
        // return ft.format("%1$tY��%1$tm��%1$td��", cal).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("HH:mm");
        return sdf.format(millis * 1000);
    }

    public static String getDateMonth(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("MM");
        return switchDate(sdf.format(millis * 1000));
    }

    public static String getDateDay(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("dd");
        return sdf.format(millis * 1000);
    }

    public static long getTelentTime(int mil) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, mil);
        return cal.getTimeInMillis();
    }

    public static String switchDate(String date) {
        // ToLog.Loge("time", date);
        if (date.equals("01"))
            return "һ��";
        else if (date.equals("02"))
            return "����";
        else if (date.equals("03"))
            return "����";
        else if (date.equals("04"))
            return "����";
        else if (date.equals("05"))
            return "����";
        else if (date.equals("06"))
            return "����";
        else if (date.equals("07"))
            return "����";
        else if (date.equals("08"))
            return "����";
        else if (date.equals("09"))
            return "����";
        else if (date.equals("10"))
            return "ʮ��";
        else if (date.equals("11"))
            return "ʮһ��";
        else
            return "ʮ����";

    }

    public static String getTimeInterval(long millis) {
        long interval = System.currentTimeMillis() - millis * 1000;
        long mint = interval / (1000);
        int hor = (int) mint / 3600;
        int secd = (int) mint % 3600;
        int day = (int) hor / 24;
        // ToLog.Loge("secd", ""+secd);
        // ToLog.Loge("hor", ""+hor);
        // ToLog.Loge("day", ""+day);
        if (day > 0 || hor > 23) {
            if (day <= 5)
                return day + "��ǰ";
            else
                return getDateStr(millis);
        } else {
            if (hor < 1) {
                if (secd <= 3)
                    return "�ո�";
                else if (secd > 3 && secd < 60)
                    return Math.abs(secd) + "��ǰ";
                else
                    return secd / 60 + "����ǰ";
            } else {
                return hor + "Сʱǰ";
            }
        }

    }

    public static String getDuring(long millis) {
        // int hor = (int)(millis / (1000 * 60 * 60 *24) + 0.5);
        int hor = (int) millis / 60;
        return String.valueOf(hor);
    }

    public static String getDataString(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (null == time || "".equals(time)) {
            return " ";
        }
        try {
            Date date = sdf.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);


            String y = String.valueOf(calendar.get(Calendar.YEAR));
            String m = String.valueOf(calendar.get(Calendar.MARCH) + 1);
            String d = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            String w = "";
            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                w = "��";
            } else {
                w = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK) - 1);
            }
            return y + "-" + m + "-" + d + " ����" + w;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return time;

    }

    public static String getDayString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String d = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        return d;
    }

    public static String getTimeStr(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("HH:mm");
        return sdf.format(millis);
    }


    public static List<String> getTimeList(int size) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        List<String> list = null;
        list = new ArrayList<String>();

        list.add("今天");
        for (int i = 0; i < size - 1; i++) {

            calendar.add(calendar.DATE, 1);
            date = calendar.getTime();
            String dateString = formatter.format(date);
            if (i == 0) {
                list.add("明天");
            } else {
                list.add(dateString);
            }

        }
        return list;
    }


    /**
     * stringForTime:将数值时间转为00:00:00
     *
     * @param timeMs 时间数
     * @return 时间格式为：00:00:00
     * @author zengxiao
     * @since JDK 1.6
     */
    public static String stringForTime(int timeMs) {
        int totalSeconds = timeMs / 1000;

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
                .toString();
    }

    /**
     * stringForTime:将数值时间转为00:00:00
     *
     * @param timeMs 时间数
     * @return 时间格式为：00:00:00
     * @author zengxiao
     * @since JDK 1.6
     */
    public static String stringForTime(long timeMs) {

        if(timeMs < 0) timeMs =0;

        long totalSeconds = timeMs / 1000;

        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
                .toString();
    }

    /**
     * 获取增加多少天的时间
     *
     * @return addDay - 增加多少天
     */
    public static Date getAddDayDate(int addDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, addDay);
        return calendar.getTime();
    }
}
