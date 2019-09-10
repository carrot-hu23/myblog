package com.hujinbo.blogs.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 时间工具类
 * @author hujinbo
 * @version 1.0
 * @date 2019/8/28 15:41
 */
public final class TimeUtil {

    /**
     * 计算数据库存储时间和当前时间差
     * @param past 数据库存储的时间戳
     * @return 返回字符串
     */
    public static String currentTimeDifferences(Timestamp past) {
        //数据库保存时间
        Date before = new Date(past.getTime());
        //当前时间
        Date now = new Date();
        Long diff = getTwoTimeDifferences(now,before);
        return millisecondTransformIntoString(diff);
    }

    /**
     * 计算两个时间差
     * @param first 第一个时间
     * @param second 第二个时间
     * @return 返回相差多少毫秒
     */
    private static long getTwoTimeDifferences(Date first,Date second) {
        long diff = first.getTime() - second.getTime();
        return diff;
    }
    /**
     * 一分钟
     * */
    private static final long ONE_MINUTE = 60000L;
    /**
     * 一小时
     * */
    private static final long ONE_HOUR = 3600000L;
    /**
     * 一天
     * */
    private static final long ONE_DAY = 86400000L;
    /**
     * 一个月
     * */
    private static final long ONE_MONTH = 30*ONE_DAY;

    private static final Long ONE_YEAR = 12 * ONE_MONTH;

    /**
     * 毫秒转换成String表示 【几个月前，几天前，几小时前，几分钟前】
     * @param ms 之前计算得到的多少毫秒
     * @return 时间差
     * @version 1.0     此方法没有测试，有可能出现bug，而且不完善
     */
    private static String millisecondTransformIntoString( final Long ms) {

        if (ms < ONE_MINUTE) {
            return toSeconds(ms) + "秒前";
        } else if (ms < ONE_HOUR) {
            return toMinutes(ms) + "分钟前";
        } else if (ms < ONE_DAY) {
            return toHours(ms) + "小时前";
        } else if (ms < ONE_MONTH) {
            Long num = toDays(ms);
            int two = 2;
            if (num < two ) {
                return "昨天";
            }
            return num + "天前";
        } else if (ms < ONE_YEAR) {
            return toMonths(ms) + "个月前";
        }
        return null;
    }
    /***
     * 毫秒转秒
     */
    private static long toSeconds(long ms) {
        return ms / 1000L;
    }
    /***
     * 毫秒转分钟
     */
    private static long toMinutes(long ms) {
        return toSeconds(ms) / 60L;
    }
    /***
     * 毫秒转小时
     */
    private static long toHours(long ms) {
        return toMinutes(ms) / 60L;
    }
    /***
     * 毫秒转天
     */
    private static long toDays(long ms) {
        return toHours(ms) / 24L;
    }
    /***
     * 毫秒转月
     */
    private static long toMonths(long ms) {
        return toDays(ms) / 30L;
    }
    /***
     * 毫秒转年
     */
    private static long toYears(long ms) {
        return toMonths(ms) / 365L;
    }
}
