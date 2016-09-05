package com.test.violationsdrivecarCommon.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * <pre> 
 *
 *    
 *    时间工具类：
 * G 年代标志符
  y 年
  M 月
  d 日
  h 时 在上午或下午 (1~12)
  H 时 在一天中 (0~23)
  m 分
  s 秒
  S 毫秒
  E 星期
  D 一年中的第几天
  F 一月中第几个星期几
  w 一年中第几个星期
  W 一月中第几个星期
  a 上午 / 下午 标记符 
  k 时 在一天中 (1~24)
  K 时 在上午或下午 (0~11)
  z 时区
 *</pre>
 * @date 2015年11月5日 下午2:52:30
 */
public class DateTimeUtil {

    private final static String dateFormatZ = "yyyy-MM-dd'T'HH:mm:ssZ";
    private final static String datetimeFormat = "yyyy-MM-dd HH:mm:ss";
    private final static String dateFormat = "yyyy-MM-dd";
    private final static String dateFormat2 = "yyyyMMdd";
    private final static String timeFormat = "HH:mm:ss";
    private final static String dateTimeFormat2 = "yyyyMMddHHmmssSSS";
    private final static String dateTimeFormat4 = "yyyyMMddHHmmss";
    

    /**
     * 相对于某一个时间的相对时间
     * @param source
     * @param relative
     * @return
     */
    public static Date getRelativeDate(Date source,Long relative){

        if(source == null) {
            return null;
        }
        Long time = source.getTime();
        Long result = time + relative * 1000;
        return new Date(result);
    }

    /**
     * 获得当前日期时间
     * <p>
     * 日期时间格式yyyyMMddHHmmss
     * 
     * @return
     */
    public static String currentDatetime4(){

        return new SimpleDateFormat(dateTimeFormat4).format(now());
    }
    /**
     *
     * 当前时间增加若干分钟数
     * <p>
     * 日期时间格式 yyyyMMddHHmmss
     *
     * @param min 增加的分钟数
     * @return yyyyMMddHHmmss
     */
    public static String addCurrentTime4(int min){
        Date date = new Date();
        long l1 = date.getTime();
        l1 = l1 + min * 60 * 1000;
        return new SimpleDateFormat(dateTimeFormat4).format(new Date(l1));
    }
    /**
     * 获得当前日期时间
     * <p>
     * 日期时间格式yyyyMMddHHmmssSSS
     *
     * @return
     */
    public static String currentDatetime2(){

        return new SimpleDateFormat(dateTimeFormat2).format(now());
    }
    /**
     * <pre> 
     *
     * 获得当前时间：格式为：yyyy-MM-dd'T'HH:mm:ssZ
     *</pre> 
     * @return String
     */
    public static String currentDatetime3(){
        return new SimpleDateFormat(dateFormatZ).format(now());
    }
    /**
     * <pre> 
     *
     * 获得当前时间：格式为：yyyy-MM-dd'T'HH:mm:ssZ
     *</pre> 
     * @return String
     */
    public static String currentDatetime3(Date date){
    	return new SimpleDateFormat(dateFormatZ).format(date);
    }

    /**
     * 日期格式换 yyyyMMdd
     * @param date
     * @return
     */
    public static String formatDateToString(Date date){

        return new SimpleDateFormat(dateFormat2).format(date);
    }

    /**
     * 字符格式为 yyyyMMddhhmmss转换成日期Date
     * 
     * @param src
     * @return
     * @throws ParseException
     */
    public static Date formatDate(String src) throws ParseException{

        return stringtoDate(src,"yyyyMMddHHmmss");
    }

    /**
     * 时间加减
     * @param srcTime 时间
     * @param min 分钟数，负数为减
     * @return
     */
    public static String addMin(String srcTime,int min){

        Date date;
        try{
            date = parseDatetime(srcTime);
            long l1 = date.getTime();
            l1 = l1 + min * 60 * 1000;
            return formatDatetime(new Date(l1));
        }catch(ParseException e){
            e.printStackTrace();
        }
        return "";

    }

    /**
     * 由字符串转化成时间
     * @return yyyy-MM-dd HH:mm:ss
     * @throws ParseException
     */
    public static Date stringtoDate(String now,String format) throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(now);
    }

    /**
     * 由时间转化成字符串 format示例：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String datetoString(Date now,String format){

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(now);
    }

    /**
     * 比较时间大小 如果d1>d2 返回true，否则返回false
     * @param date1
     * @param date2
     * @return
     */

    public static boolean compareToTime(String date1,String date2){

        try{
            Date d1 = new SimpleDateFormat(timeFormat).parse(date1);
            Date d2 = new SimpleDateFormat(timeFormat).parse(date2);
            if(d1.getTime() > d2.getTime()) {

                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }

    /**
     * 验证当前时间是否在 time1,time2 之间
     * @return
     * @throws ParseException
     */
    public static boolean isIntime(String date1,String date2){

        if(ComUtil.isEmpty(date1) || ComUtil.isEmpty(date2)) {// 如果开始时间和结束时间任何一个为空，则返回true
            return true;
        }
        String currentTime = new SimpleDateFormat(timeFormat).format(new Date());
        if(date1.compareTo(currentTime) <= 0 && date2.compareTo(currentTime) >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 获得当前日期时间
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String currentDatetime(){

        return new SimpleDateFormat(datetimeFormat).format(now());
    }
    /**
     * 将时间字符串转为日期格式
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @return
     * @throws ParseException 
     */
    public static Date strtimeToDate(String date) throws ParseException{
    	
    	return new SimpleDateFormat(datetimeFormat).parse(date);
    }

    /**
     * 格式化日期时间
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String formatDatetime(Date date){

        return new SimpleDateFormat(datetimeFormat).format(date);
    }

    /**
     * 格式化日期时间
     * 
     * @param date
     * @param pattern 格式化模式，详见{@link SimpleDateFormat}构造器
     *        <code>SimpleDateFormat(String pattern)</code>
     * @return
     */
    public static String formatDatetime(Date date,String pattern){

        SimpleDateFormat customFormat = (SimpleDateFormat)new SimpleDateFormat(datetimeFormat).clone();
        customFormat.applyPattern(pattern);
        return customFormat.format(date);
    }

    /**
     * 获得当前日期
     * <p>
     * 日期格式yyyy-MM-dd
     * 
     * @return
     */
    public static String currentDate(){

        return new SimpleDateFormat(dateFormat).format(now());
    }

    /**
     * 格式化日期
     * <p>
     * 日期格式yyyy-MM-dd
     * 
     * @return
     */
    public static String formatDate(Date date){

        return new SimpleDateFormat(dateFormat).format(date);
    }

    /**
     * 获得当前时间
     * <p>
     * 时间格式HH:mm:ss
     * 
     * @return
     */
    public static String currentTime(){

        return new SimpleDateFormat(timeFormat).format(now());
    }

    /**
     * 格式化时间
     * <p>
     * 时间格式HH:mm:ss
     * 
     * @return
     */
    public static String formatTime(Date date){

        return new SimpleDateFormat(timeFormat).format(date);
    }

    /**
     * 获得当前时间的<code>java.util.Date</code>对象
     * 
     * @return
     */
    public static Date now(){

        return new Date();
    }

    public static Calendar calendar(){

        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return cal;
    }

    /**
     * 获得当前时间的毫秒数
     * <p>
     * 详见{@link System#currentTimeMillis()}
     * 
     * @return
     */
    public static long millis(){

        return System.currentTimeMillis();
    }

    /**
     * 
     * 获得当前Chinese月份
     * 
     * @return
a     */
    public static int getMonth(){

        return calendar().get(Calendar.MONTH) + 1;
    }

    /**
     * 获得月份中的第几天
     * 
     * @return
     */
    public static int dayOfMonth(){

        return calendar().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得年份
     * @return
     */
    public static int getYear(){
        return calendar().get(Calendar.YEAR);
    }

    public static void main(String args[]) throws ParseException{

        System.out.println(getYear());
        System.out.println(getMonth());
        System.out.println(calendar().get(Calendar.DAY_OF_MONTH)-1);
        Calendar  cal = calendar();
        cal.add(Calendar.DATE,-1);
        System.out.println(cal.getTime());


    }

    /**
     * 今天是星期的第几天
     * 
     * @return
     */
    public static int dayOfWeek(){

        return calendar().get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 今天是年中的第几天
     * 
     * @return
     */
    public static int dayOfYear(){

        return calendar().get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 判断原日期是否在目标日期之前
     * 
     * @param src
     * @param dst
     * @return
     */
    public static boolean isBefore(Date src,Date dst){

        return src.before(dst);
    }

    /**
     * 判断原日期是否在目标日期之后
     * 
     * @param src
     * @param dst
     * @return
     */
    public static boolean isAfter(Date src,Date dst){

        return src.after(dst);
    }

    /**
     * 判断两日期是否相同
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqual(Date date1,Date date2){

        return date1.compareTo(date2) == 0;
    }

    /**
     * 判断某个日期是否在某个日期范围
     * 
     * @param beginDate 日期范围开始
     * @param endDate 日期范围结束
     * @param src 需要判断的日期
     * @return
     */
    public static boolean between(Date beginDate,Date endDate,Date src){

        return beginDate.before(src) && endDate.after(src);
    }

    /**
     * 获得当前月的最后一天
     * <p>
     * HH:mm:ss为0，毫秒为999
     * 
     * @return
     */
    public static Date lastDayOfMonth(){

        Calendar cal = calendar();
        cal.set(Calendar.DAY_OF_MONTH,0); // M月置零
        cal.set(Calendar.HOUR_OF_DAY,0);// H置零
        cal.set(Calendar.MINUTE,0);// m置零
        cal.set(Calendar.SECOND,0);// s置零
        cal.set(Calendar.MILLISECOND,0);// S置零
        cal.set(Calendar.MONTH,cal.get(Calendar.MONTH) + 1);// 月份+1
        cal.set(Calendar.MILLISECOND,-1);// 毫秒-1
        return cal.getTime();
    }

    /**
     * 获得当前月的第一天
     * <p>
     * HH:mm:ss SS为零
     * 
     * @return
     */
    public static Date firstDayOfMonth(){

        Calendar cal = calendar();
        cal.set(Calendar.DAY_OF_MONTH,1); // M月置1
        cal.set(Calendar.HOUR_OF_DAY,0);// H置零
        cal.set(Calendar.MINUTE,0);// m置零
        cal.set(Calendar.SECOND,0);// s置零
        cal.set(Calendar.MILLISECOND,0);// S置零
        return cal.getTime();
    }

    private static Date weekDay(int week){

        Calendar cal = calendar();
        cal.set(Calendar.DAY_OF_WEEK,week);
        return cal.getTime();
    }

    /**
     * 获得周五日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * 
     * @return
     */
    public static Date friday(){

        return weekDay(Calendar.FRIDAY);
    }

    /**
     * 获得周六日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * 
     * @return
     */
    public static Date saturday(){

        return weekDay(Calendar.SATURDAY);
    }

    /**
     * 获得周日日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * 
     * @return
     */
    public static Date sunday(){

        return weekDay(Calendar.SUNDAY);
    }

    /**
     * 将字符串日期时间转换成java.util.Date类型
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @param datetime
     * @return
     */
    public static Date parseDatetime(String datetime) throws ParseException{

        return new SimpleDateFormat(datetimeFormat).parse(datetime);
    }

    /**
     * 将字符串日期转换成java.util.Date类型
     * <p>
     * 日期时间格式yyyy-MM-dd
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException{

        return new SimpleDateFormat(dateFormat).parse(date);
    }

    /**
     * 将字符串日期转换成java.util.Date类型
     * <p>
     * 时间格式 HH:mm:ss
     * 
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date parseTime(String time) throws ParseException{

        return new SimpleDateFormat(timeFormat).parse(time);
    }

    /**
     * 根据自定义pattern将字符串日期转换成java.util.Date类型
     * 
     * @param datetime
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parseDatetime(String datetime,String pattern) throws ParseException{

        SimpleDateFormat format = (SimpleDateFormat)new SimpleDateFormat(datetimeFormat).clone();
        format.applyPattern(pattern);
        return format.parse(datetime);
    }

    /**
     * 将日期转换为 xx月xx日
     * @param date
     * @return
     */
    public static String dateToMouthAddDay(Date date){

        SimpleDateFormat myFormat = new SimpleDateFormat("MM月dd日");
        return myFormat.format(date);
    }

    /**
     * 与当前系统时间相比，如果小于当前系统时间 返回true
     * @param srcTime
     * @return
     */
    public static boolean before(String srcTime){

        String compareTime = currentDatetime();
        return before(srcTime,compareTime);
    }

    /**
     * 比较两个时间大小,如果srcDate小于compareDate 返回true
     * @param srcTime
     * @param compareTime
     * @return
     */
    public static boolean before(String srcTime,String compareTime){

        if(srcTime.compareTo(compareTime) > 0) {
            return false;
        }
        return true;
    }

}
