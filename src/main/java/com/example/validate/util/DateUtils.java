/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author jiangchao
 * @date  2019-04-25 16:24
 */
package com.example.validate.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 类或方法的功能描述 :TODO
 *
 * @author jiangchaoo
 * @date 2019-04-25 16:24
 */
public class DateUtils {


    /**
     * 法定假日.
     */
    private static Map<Integer, List<Date>> LEGALHOLIDAY = Maps.newConcurrentMap();

    /**
     * 法定工作日.
     */
    private static Map<Integer, List<Date>> LEGALWORKDAY = Maps.newConcurrentMap();

    /**
     * 时间判断格式.
     */
    private static Map<String, String> DATE_PATTERN_MAP = Maps.newConcurrentMap();

    // Grace style
    public static final String PATTERN_GRACE = "yyyy/MM/dd HH:mm:ss";
    public static final String PATTERN_GRACE_NORMAL = "yyyy/MM/dd HH:mm";
    public static final String PATTERN_GRACE_SIMPLE = "yyyy/MM/dd";

    // Classical style
    public static final String PATTERN_CLASSICAL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_CLASSICAL_NORMAL = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_CLASSICAL_SIMPLE = "yyyy-MM-dd";
    public static final String PATTERN_CLASSICAL_TIME = "HH:mm:ss";

    //CH style
    public static final String PATTERN_CH = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String PATTERN_CH_NORMAL = "yyyy年MM月dd日 HH时mm分";
    public static final String PATTERN_CH_SIMPLE = "yyyy年MM月dd日";


    private DateUtils() {
        // Cannot be instantiated
    }

    static {
        DATE_PATTERN_MAP.put(PATTERN_CLASSICAL_TIME, "\\d{1,2}:\\d{1,2}:\\d{1,2}");

        DATE_PATTERN_MAP.put(PATTERN_GRACE_SIMPLE, "\\d{4}/\\d{1,2}/\\d{1,2}");
        DATE_PATTERN_MAP.put(PATTERN_GRACE, DATE_PATTERN_MAP.get(PATTERN_GRACE_SIMPLE) + " " + DATE_PATTERN_MAP.get(PATTERN_CLASSICAL_TIME));
        DATE_PATTERN_MAP.put(PATTERN_GRACE_NORMAL, DATE_PATTERN_MAP.get(PATTERN_GRACE_SIMPLE) + " \\d{1,2}:\\d{1,2}");

        DATE_PATTERN_MAP.put(PATTERN_CLASSICAL_SIMPLE, "\\d{4}-\\d{1,2}-\\d{1,2}");
        DATE_PATTERN_MAP.put(PATTERN_CLASSICAL, DATE_PATTERN_MAP.get(PATTERN_CLASSICAL_SIMPLE) + " " + DATE_PATTERN_MAP.get(PATTERN_CLASSICAL_TIME));
        DATE_PATTERN_MAP.put(PATTERN_CLASSICAL_NORMAL, DATE_PATTERN_MAP.get(PATTERN_CLASSICAL_SIMPLE) + " \\d{1,2}:\\d{1,2}");

        DATE_PATTERN_MAP.put(PATTERN_CH_SIMPLE, "\\d{4}年\\d{1,2}月\\d{1,2}日");
        DATE_PATTERN_MAP.put(PATTERN_CH, DATE_PATTERN_MAP.get(PATTERN_CH_SIMPLE) + " \\d{1,2}时\\d{1,2}分\\d{1,2}秒");
        DATE_PATTERN_MAP.put(PATTERN_CH_NORMAL, DATE_PATTERN_MAP.get(PATTERN_CH_SIMPLE) + " \\d{1,2}时\\d{1,2}分");


        List<Date> legalHoliday2014 = Lists.newArrayList();
        legalHoliday2014.add(new GregorianCalendar(2014, 0, 1).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 0, 31).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 1, 3).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 1, 4).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 1, 5).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 1, 6).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 3, 7).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 4, 1).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 4, 2).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 6, 2).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 8, 8).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 9, 1).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 9, 2).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 9, 3).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 9, 6).getTime());
        legalHoliday2014.add(new GregorianCalendar(2014, 9, 7).getTime());
        LEGALHOLIDAY.put(2014, legalHoliday2014);

        List<Date> legalHoliday2015 = Lists.newArrayList();
        legalHoliday2015.add(new GregorianCalendar(2015, 0, 1).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 0, 2).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 1, 18).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 1, 19).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 1, 20).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 1, 23).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 1, 24).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 3, 6).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 4, 1).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 5, 22).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 8, 3).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 8, 4).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 9, 1).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 9, 2).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 9, 5).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 9, 6).getTime());
        legalHoliday2015.add(new GregorianCalendar(2015, 9, 7).getTime());
        LEGALHOLIDAY.put(2015, legalHoliday2015);

        List<Date> legalHoliday2016 = Lists.newArrayList();
        legalHoliday2016.add(new GregorianCalendar(2016, 0, 1).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 1, 8).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 1, 9).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 1, 10).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 1, 11).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 1, 12).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 3, 4).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 4, 2).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 5, 9).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 5, 10).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 8, 15).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 8, 16).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 9, 3).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 9, 4).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 9, 5).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 9, 6).getTime());
        legalHoliday2016.add(new GregorianCalendar(2016, 9, 7).getTime());
        LEGALHOLIDAY.put(2016, legalHoliday2016);

        List<Date> legalHoliday2017 = Lists.newArrayList();

        LEGALHOLIDAY.put(2017, legalHoliday2017);

        List<Date> legalHoliday2018 = Lists.newArrayList();

        LEGALHOLIDAY.put(2018, legalHoliday2018);


        List<Date> legalWorkday2014 = Lists.newArrayList();
        legalWorkday2014.add(new GregorianCalendar(2014, 0, 26).getTime());
        legalWorkday2014.add(new GregorianCalendar(2014, 1, 8).getTime());
        legalWorkday2014.add(new GregorianCalendar(2014, 4, 4).getTime());
        legalWorkday2014.add(new GregorianCalendar(2014, 8, 28).getTime());
        legalWorkday2014.add(new GregorianCalendar(2014, 9, 11).getTime());
        LEGALWORKDAY.put(2014, legalWorkday2014);

        List<Date> legalWorkday2015 = Lists.newArrayList();
        legalWorkday2015.add(new GregorianCalendar(2015, 0, 4).getTime());
        legalWorkday2015.add(new GregorianCalendar(2015, 1, 15).getTime());
        legalWorkday2015.add(new GregorianCalendar(2015, 8, 6).getTime());
        legalWorkday2015.add(new GregorianCalendar(2015, 9, 10).getTime());
        LEGALWORKDAY.put(2015, legalWorkday2015);

        List<Date> legalWorkday2016 = Lists.newArrayList();
        legalWorkday2016.add(new GregorianCalendar(2016, 5, 12).getTime());
        legalWorkday2016.add(new GregorianCalendar(2016, 8, 18).getTime());
        legalWorkday2016.add(new GregorianCalendar(2016, 8, 6).getTime());
        legalWorkday2016.add(new GregorianCalendar(2016, 9, 8).getTime());
        legalWorkday2016.add(new GregorianCalendar(2016, 9, 9).getTime());
        LEGALWORKDAY.put(2016, legalWorkday2016);

        List<Date> legalWorkday2017 = Lists.newArrayList();

        LEGALWORKDAY.put(2017, legalWorkday2017);

        List<Date> legalWorkday2018 = Lists.newArrayList();

        LEGALWORKDAY.put(2018, legalWorkday2018);
    }

    /**
     * 根据默认格式将指定字符串解析成日期
     *
     * @param str 指定字符串
     * @return 返回解析后的日期
     */
    public static Date parse(String str) {
        String pattern = "";
        for (Map.Entry<String, String> entry : DATE_PATTERN_MAP.entrySet()) {
            if (StringUtils.isNotBlank(entry.getValue())) {
                if (Pattern.matches(entry.getValue(), str)) {
                    pattern = entry.getKey();
                    break;
                }
            }
        }
        return parse(str, pattern);
    }

    /**
     * 根据指定格式将指定字符串解析成日期
     *
     * @param str     指定日期
     * @param pattern 指定格式
     * @return 返回解析后的日期
     */
    public static Date parse(String str, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据默认格式将日期转格式化成字符串
     *
     * @param date 指定日期
     * @return 返回格式化后的字符串
     */
    public static String format(Date date) {
        return format(date, PATTERN_CLASSICAL);
    }

    /**
     * 根据默认格式将时间转格式化成字符串
     *
     * @param time 指定日期
     * @return 返回格式化后的字符串
     */
    public static String format(long time) {
        Date date = new Date(time);
        return format(date, PATTERN_CLASSICAL);
    }

    /**
     * 根据指定格式将指定日期格式化成字符串
     *
     * @param date    指定日期
     * @param pattern 指定格式
     * @return 返回格式化后的字符串
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 根据指定格式将指定时间格式化成字符串
     *
     * @param time    指定时间
     * @param pattern 指定格式
     * @return 返回格式化后的字符串
     */
    public static String format(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取时间date1与date2相差的秒数
     *
     * @param date1 起始时间
     * @param date2 结束时间
     * @return 返回相差的秒数
     */
    public static int getOffsetSeconds(Date date1, Date date2) {
        int seconds = (int) ((date2.getTime() - date1.getTime()) / 1000);
        return seconds;
    }

    /**
     * 获取时间date1与date2相差的分钟数
     *
     * @param date1 起始时间
     * @param date2 结束时间
     * @return 返回相差的分钟数
     */
    public static int getOffsetMinutes(Date date1, Date date2) {
        return getOffsetSeconds(date1, date2) / 60;
    }

    /**
     * 获取时间date1与date2相差的小时数
     *
     * @param date1 起始时间
     * @param date2 结束时间
     * @return 返回相差的小时数
     */
    public static int getOffsetHours(Date date1, Date date2) {
        return getOffsetMinutes(date1, date2) / 60;
    }

    /**
     * 获取时间date1与date2相差的天数数
     *
     * @param date1 起始时间
     * @param date2 结束时间
     * @return 返回相差的天数
     */
    public static int getOffsetDays(Date date1, Date date2) {
        return getOffsetHours(date1, date2) / 24;
    }

    /**
     * 获取时间date1与date2相差的周数
     *
     * @param date1 起始时间
     * @param date2 结束时间
     * @return 返回相差的周数
     */
    public static int getOffsetWeeks(Date date1, Date date2) {
        return getOffsetDays(date1, date2) / 7;
    }


    public static Date getDateTime(int year, int month, int day, int hour, int minute, int second, int mmmm) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.MILLISECOND, mmmm);
        return cal.getTime();
    }

    /**
     * 获取重置指定日期的时分秒后的时间
     *
     * @param date   指定日期
     * @param hour   指定小时
     * @param minute 指定分钟
     * @param second 指定秒
     * @return 返回重置时分秒后的时间
     */
    public static Date getResetTime(Date date, int hour, int minute, int second) {
        return getResetTime(date, hour, minute, second, 0);
    }

    /**
     * 获取重置指定日期的时分秒后的时间
     *
     * @param date   指定日期
     * @param hour   指定小时
     * @param minute 指定分钟
     * @param second 指定秒
     * @return 返回重置时分秒后的时间
     */
    public static Date getResetTime(Date date, int hour, int minute, int second, int mmmm) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.MILLISECOND, mmmm);
        return cal.getTime();
    }

    /**
     * 返回指定日期的起始时间
     *
     * @param date 指定日期（例如2014-08-01）
     * @return 返回起始时间（例如2014-08-01 00:00:00）
     */
    public static Date getIntegralStartTime(Date date) {
        return getResetTime(date, 0, 0, 0);
    }

    /**
     * 返回指定日期的结束时间
     *
     * @param date 指定日期（例如2014-08-01）
     * @return 返回结束时间（例如2014-08-01 23:59:59）
     */
    public static Date getIntegralEndTime(Date date) {
        return getResetTime(date, 23, 59, 59);
    }

    /**
     * 获取指定日期累加年月日后的时间
     *
     * @param date  指定日期
     * @param year  指定年数
     * @param month 指定月数
     * @param day   指定天数
     * @return 返回累加年月日后的时间
     */
    public static Date rollDate(Date date, int year, int month, int day, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.YEAR, year);
        cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DAY_OF_MONTH, day);
        cal.add(Calendar.HOUR, hour);
        cal.add(Calendar.MINUTE, minute);
        cal.add(Calendar.SECOND, second);
        return cal.getTime();
    }

    /**
     * 获取指定日期累加指定月数后的时间
     *
     * @param date  指定日期
     * @param month 指定月数
     * @return 返回累加月数后的时间
     */
    public static Date rollMonth(Date date, int month) {
        return rollDate(date, 0, month, 0, 0, 0, 0);
    }

    /**
     * 获取指定日期累加指定天数后的时间
     *
     * @param date 指定日期
     * @param day  指定天数
     * @return 返回累加天数后的时间
     */
    public static Date rollDay(Date date, int day) {
        return rollDate(date, 0, 0, day, 0, 0, 0);
    }

    /**
     * 获取指定日期累加指定天数后的时间
     *
     * @param date 指定日期
     * @param hour 指定小时
     * @return 返回累加天数后的时间
     */
    public static Date rollHour(Date date, int hour) {
        return rollDate(date, 0, 0, 0, hour, 0, 0);
    }

    /**
     * 获取指定日期累加指定天数后的时间
     *
     * @param date   指定日期
     * @param minute 指定分钟
     * @return 返回累加天数后的时间
     */
    public static Date rollMinute(Date date, int minute) {
        return rollDate(date, 0, 0, 0, 0, minute, 0);
    }

    /**
     * 计算指定日期所在月份的天数
     *
     * @param date 指定日期
     * @return 返回所在月份的天数
     */
    public static int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        int dayOfMonth = cal.getActualMaximum(Calendar.DATE);
        return dayOfMonth;
    }

    /**
     * 获取当月第一天的起始时间，例如2014-08-01 00:00:00
     *
     * @return 返回当月第一天的起始时间
     */
    public static Date getMonthStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getIntegralStartTime(cal.getTime());
    }

    /**
     * 获取当月第一天的起始时间，例如2014-08-01 00:00:00
     *
     * @return 返回当月第一天的起始时间
     */
    public static Date getMonthStartTime(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getIntegralStartTime(cal.getTime());
    }

    /**
     * 获取当月最后一天的结束时间，例如2014-08-31 23:59:59
     *
     * @return 返回当月最后一天的结束时间
     */
    public static Date getMonthEndTime(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.set(Calendar.DAY_OF_MONTH, getDayOfMonth(cal.getTime()));
        return getIntegralEndTime(cal.getTime());
    }

    /**
     * 获取当月最后一天的结束时间，例如2014-08-31 23:59:59
     *
     * @return 返回当月最后一天的结束时间
     */
    public static Date getMonthEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, getDayOfMonth(cal.getTime()));
        return getIntegralEndTime(cal.getTime());
    }


    /**
     * 获取上个月第一天的起始时间，例如2014-07-01 00:00:00
     *
     * @return 返回上个月第一天的起始时间
     */
    public static Date getLastMonthStartTime(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getIntegralStartTime(cal.getTime());
    }

    /**
     * 获取上个月第一天的起始时间，例如2014-07-01 00:00:00
     *
     * @return 返回上个月第一天的起始时间
     */
    public static Date getLastMonthStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getIntegralStartTime(cal.getTime());
    }

    /**
     * 获取上个月最后一天的结束时间，例如2014-07-31 23:59:59
     *
     * @return 返回上个月最后一天的结束时间
     */
    public static Date getLastMonthEndTime(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, getDayOfMonth(cal.getTime()));
        return getIntegralEndTime(cal.getTime());
    }

    /**
     * 获取上个月最后一天的结束时间，例如2014-07-31 23:59:59
     *
     * @return 返回上个月最后一天的结束时间
     */
    public static Date getLastMonthEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, getDayOfMonth(cal.getTime()));
        return getIntegralEndTime(cal.getTime());
    }

    /**
     * 获取下个月第一天的起始时间，例如2014-09-01 00:00:00
     *
     * @return 返回下个月第一天的起始时间
     */
    public static Date getNextMonthStartTime() {
        return getNextMonthStartTime(null);
    }

    public static Date getNextMonthStartTime(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getIntegralStartTime(cal.getTime());
    }

    /**
     * 获取下个月最后一天的结束时间，例如2014-09-30 23:59:59
     *
     * @return 返回下个月最后一天的结束时间
     */
    public static Date getNextMonthEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, getDayOfMonth(cal.getTime()));
        return getIntegralEndTime(cal.getTime());
    }

    /**
     * 获取当前季度第一天的起始时间
     *
     * @return 返回当前季度第一天的起始时间
     */
    public static Date getQuarterStartTime() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        if (month < 3) {
            cal.set(Calendar.MONTH, 0);
        } else if (month < 6) {
            cal.set(Calendar.MONTH, 3);
        } else if (month < 9) {
            cal.set(Calendar.MONTH, 6);
        } else {
            cal.set(Calendar.MONTH, 9);
        }
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getIntegralStartTime(cal.getTime());
    }

    /**
     * 获取当前季度最后一天的结束时间
     *
     * @return 返回当前季度最后一天的结束时间
     */
    public static Date getQuarterEndTime() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        if (month < 3) {
            cal.set(Calendar.MONTH, 2);
        } else if (month < 6) {
            cal.set(Calendar.MONTH, 5);
        } else if (month < 9) {
            cal.set(Calendar.MONTH, 8);
        } else {
            cal.set(Calendar.MONTH, 11);
        }
        cal.set(Calendar.DAY_OF_MONTH, getDayOfMonth(cal.getTime()));
        return getIntegralEndTime(cal.getTime());
    }

    /**
     * 获取前一个工作日
     *
     * @return 返回前一个工作日
     */
    public static Date getPrevWorkday() {
        return getPrevWorkday(null);
    }

    /**
     * 获取前一个工作日
     *
     * @param date 日期
     * @return 返回前一个工作日
     */
    public static Date getPrevWorkday(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        Date workday = rollDay(date, -1);
        while (!isWorkday(workday)) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                cal.add(Calendar.DAY_OF_MONTH, -2);
            }
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            workday = getIntegralStartTime(cal.getTime());
        }
        return workday;
    }

    /**
     * 获取下一个工作日
     *
     * @param date 日期
     * @return 返回下个工作日
     */
    public static Date getNextWorkday(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        Date workday = rollDay(date, 1);
        while (!isWorkday(workday)) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                cal.add(Calendar.DAY_OF_MONTH, 2);
            }
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            workday = getIntegralStartTime(cal.getTime());
        }
        return workday;
    }

    /**
     * 获取第N个工作日
     *
     * @param date 日期
     * @param day  N个工作日
     * @return 返回下个工作日
     */
    public static Date getWorkday(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        if (day == 0) {
            throw new IllegalArgumentException("day parameter can not be 0 ");
        } else {
            int num = 0;
            Date workday = date;
            while (num < Math.abs(day)) {
                if (day > 0) {
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                } else {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                workday = getIntegralStartTime(cal.getTime());
                if (isWorkday(workday)) {
                    num++;
                }
            }
            return workday;
        }
    }

    /**
     * 获取下一个工作日
     *
     * @return 返回下个工作日
     */
    public static Date getNextWorkday() {
        return getNextWorkday(null);
    }

    /**
     * 获取当周的第一个工作日
     *
     * @return 返回第一个工作日
     */
    public static Date getFirstWorkday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date workday = getIntegralStartTime(cal.getTime());
        while (!isWorkday(workday)) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            workday = getIntegralStartTime(cal.getTime());
        }
        return workday;
    }

    /**
     * 获取当周的最后一个工作日
     *
     * @return 返回最后一个工作日
     */
    public static Date getLastWorkday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        Date workday = getIntegralStartTime(cal.getTime());
        while (!isWorkday(workday)) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            workday = getIntegralStartTime(cal.getTime());
        }
        return workday;
    }

    /**
     * 判断指定日期是否是工作日
     *
     * @param date 指定日期
     * @return 如果是工作日返回true，否则返回false
     */
    public static boolean isWorkday(Date date) {
        date = getResetTime(date, 0, 0, 0, 0);
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        int year = cal.get(Calendar.YEAR);
        List<Date> legalHolidayList = LEGALHOLIDAY.get(year);
        for (Date legalHolidayDate : legalHolidayList) {
            if (getOffsetDays(date, legalHolidayDate) == 0) {//判断是否是法定假日
                return false;
            }
        }

        List<Date> legalWorkdayList = LEGALWORKDAY.get(year);
        for (Date legalWorkdayDate : legalWorkdayList) {
            if (getOffsetDays(date, legalWorkdayDate) == 0) {//判断是否是法定工作日
                return true;
            }
        }
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return !(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
    }

    /**
     * 获取指定日期是星期几
     *
     * @param date 指定日期
     * @return 返回星期几的描述
     */
    public static String getWeekdayDesc(Date date) {
        final String[] weeks = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四",
                "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return weeks[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }

    /**
     * 获取指定日期距离当前时间的时间差描述（如3小时前、1天前）
     *
     * @param date 指定日期
     * @return 返回时间差的描述
     */
    public static String getTimeOffsetDesc(Date date) {
        int seconds = getOffsetSeconds(date, new Date());
        if (Math.abs(seconds) < 60) {
            return Math.abs(seconds) + "秒" + (seconds > 0 ? "前" : "后");
        }
        int minutes = seconds / 60;
        if (Math.abs(minutes) < 60) {
            return Math.abs(minutes) + "分钟" + (minutes > 0 ? "前" : "后");
        }
        int hours = minutes / 60;
        if (Math.abs(hours) < 60) {
            return Math.abs(hours) + "小时" + (hours > 0 ? "前" : "后");
        }
        int days = hours / 24;
        if (Math.abs(days) < 7) {
            return Math.abs(days) + "天" + (days > 0 ? "前" : "后");
        }
        int weeks = days / 7;
        if (Math.abs(weeks) < 5) {
            return Math.abs(weeks) + "周" + (weeks > 0 ? "前" : "后");
        }
        int monthes = days / 30;
        if (Math.abs(monthes) < 12) {
            return Math.abs(monthes) + "个月" + (monthes > 0 ? "前" : "后");
        }
        int years = monthes / 12;
        return Math.abs(years) + "年" + (years > 0 ? "前" : "后");
    }

    public static Date getNextWeek(Date date, int week) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }

        cal.add(Calendar.DATE, 7);
        cal.set(Calendar.DAY_OF_WEEK, week);

        return cal.getTime();
    }

    public static Date getNextDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date getNextWeek(int week) {
        return getNextWeek(null, week);
    }

    public static Date getPrevWeek(Date date, int week) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }

        cal.add(Calendar.DATE, -7);
        cal.set(Calendar.DAY_OF_WEEK, week);

        return cal.getTime();
    }

    public static Date getPrevWeek(int week) {
        return getPrevWeek(null, week);
    }


    /**
     * 获取当前时间
     */
    public static Date getDateTime() {
        Date date = new Date(System.currentTimeMillis());
        return date;
    }

    /**
     * 获取当前日期 （时分秒为0）
     */
    public static Date getDate() {
        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }

    /**
     * 计算指定时间的年数
     *
     * @param date 指定日期
     * @return 返回时间的年数
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    public static int getYear() {
        return getYear(null);
    }

    /**
     * 计算指定时间的月份
     *
     * @param date 指定日期
     * @return 返回时间的月份
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        int month = cal.get(Calendar.MONTH);
        return month + 1;
    }

    public static int getMonth() {
        return getMonth(null);
    }

    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static int getDay() {
        return getDay(null);
    }

    public static String getDayStartStr(Date day) {
        SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_CLASSICAL_SIMPLE);
        String beginDate = formatter.format(day);
        return beginDate + " 00:00:00";
    }

    public static Date getHourStart(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(12, 0);
        c.set(13, 0);
        return c.getTime();
    }

    /**
     * 计算指定时间的小时数
     *
     * @param date 指定日期
     * @return 返回时间的小时数
     */
    public static int getHours(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        return hours;
    }

    /**
     * 计算当前时间的小时数
     *
     * @return 返回当前时间的小时数
     */
    public static int getHours() {
        return getHours(null);
    }


    /**
     * addOrMinusDate  添加或者减少时间.
     *
     * @param date   [原始时间]
     * @param day    [天]
     * @param hour   [小时]
     * @param minute [分]
     * @param second [秒]
     * @return java.util.Date
     * @throws
     * @author jiang chao
     * @date 2019/4/25:16:50
     */
    public static Date addOrMinusDate(Date date, int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        calendar.add(Calendar.HOUR, hour);
        calendar.add(Calendar.MINUTE, minute);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 根据日期获取当前月份的最后一天
     *
     * @param day
     * @param patern
     * @return
     * @author liuyang
     * @date 2017年10月13日下午2:33:54
     */
    public static String getLastDayOfMonth(Date day, String patern) {
        SimpleDateFormat format = new SimpleDateFormat(patern);
        // 获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.setTime(day);
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);// 设置为0号,当前日期既为本月最后一天
        String lastDay = format.format(cale.getTime());
        return lastDay;
    }

    /**
     * 将字符串格式的时间转化为Date类型的日期，
     *
     * @param dateString
     * @param format
     * @return
     */
    public static Date stringToDate(String dateString, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个日期的天差
     *
     * @param beforDate
     * @param afterDate
     * @return
     */
    public static Long getDayBetweenDate(Date beforDate, Date afterDate) {
        //统一转换成 yyyy-MM-dd 格式
        beforDate = stringToDate(dateToString(beforDate, PATTERN_CLASSICAL_SIMPLE), PATTERN_CLASSICAL_SIMPLE);
        afterDate = stringToDate(dateToString(afterDate, PATTERN_CLASSICAL_SIMPLE), PATTERN_CLASSICAL_SIMPLE);
        return (afterDate.getTime() - beforDate.getTime()) / (1000 * 60 * 60 * 24);
    }

    /**
     * 将javaDate类型的日期转化为自定义格式的字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);
        return dateString;
    }


    /**
     * 获取当前日期多少天之后的日期
     *
     * @param days
     * @return
     */
    public static Date getNextDayByCurrent(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }


    /**
     * 获取某个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取某个月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }


    /**
     * 获取日期的当天结束时间字符串
     *
     * @return
     */
    public static String getDayEndStr(Date day, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String endDate = formatter.format(day);
        return endDate + " 23:59:59";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Date date = new Date();
        Date date1 = rollDay(date, -2);
        Date date2 = rollMonth(date, -3);
        Date date3 = rollHour(date, -4);
        Date date4 = rollMinute(date, -5);
        System.out.println(addOrMinusDate(date, -1, -2, 3, 4));

        System.out.println(format(date));
        System.out.println(format(date1));
        System.out.println(format(date2));
        System.out.println(format(date3));
        System.out.println(format(date4));
        System.out.println(getTimeOffsetDesc(date1));
        System.out.println(getTimeOffsetDesc(date2));
        System.out.println("获取下个月第一天的起始时间：" + format(getNextMonthStartTime(), PATTERN_CH));
        System.out.println("获取下个月最后一天的结束时间:" + format(getNextMonthEndTime()));
        System.out.println("获取前一个工作日:" + format(getPrevWorkday(), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("获取后一个工作日:" + format(getNextWorkday(), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("2015年10月08日的前一个工作日:" + format(getPrevWorkday(new GregorianCalendar(2015, 9, 8).getTime()), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("2015年09月30日的后一个工作日:" + format(getNextWorkday(new GregorianCalendar(2015, 8, 30).getTime()), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("2015年09月30日的后15个工作日:" + format(getWorkday(new GregorianCalendar(2015, 8, 30).getTime(), 15), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("2015年09月30日的前15个工作日:" + format(getWorkday(new GregorianCalendar(2015, 8, 30).getTime(), -15), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("获取当前季度第一天的起始时间：" + format(getQuarterStartTime()));
        System.out.println("获取当前季度最后一天的结束时间：" + format(getQuarterEndTime()));
        System.out.println("获取当周的第一个工作日：" + format(getFirstWorkday(), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("获取当周的最后一个工作日：" + format(getLastWorkday(), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("2014年2月8日：" + getWeekdayDesc(new GregorianCalendar(2014, 1, 8).getTime()) + (isWorkday(new GregorianCalendar(2014, 1, 8).getTime()) ? "是工作日" : "不是工作日"));
        System.out.println("2015年10月10日：" + getWeekdayDesc(new GregorianCalendar(2015, 9, 10).getTime()) + (isWorkday(new GregorianCalendar(2015, 9, 10).getTime()) ? "是工作日" : "不是工作日"));
        System.out.println("2016年6月12日：" + getWeekdayDesc(new GregorianCalendar(2016, 5, 12).getTime()) + (isWorkday(new GregorianCalendar(2016, 5, 12).getTime()) ? "是工作日" : "不是工作日"));
        System.out.println("今天是:" + getYear() + "年" + getMonth() + "月" + getDay() + "日");
        System.out.println("下周一是:" + format(getNextWeek(Calendar.MONDAY), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("上周一是:" + format(getPrevWeek(Calendar.MONDAY), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("下个月10是:" + format(rollDay(getNextMonthStartTime(), 9), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("下下个月10是:" + format(rollDay(getNextMonthStartTime(getNextMonthStartTime()), 9), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("上个月10是:" + format(rollDay(getLastMonthStartTime(), 9), PATTERN_CLASSICAL_SIMPLE));
        System.out.println("上上个月10是:" + format(rollDay(getLastMonthStartTime(getLastMonthStartTime()), 9), PATTERN_CLASSICAL_SIMPLE));
        System.out.println(getWeekdayDesc(null));
    }
}

