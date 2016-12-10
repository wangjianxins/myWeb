/**
 *
 */
package com.wangjianxin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class StringTools extends StringUtils {
    protected static Logger logger = LoggerFactory.getLogger(StringTools.class);
    protected static String HOLDER = "`[@`";

    /**
     * 字符编码变换，ISO8859-1-->UTF-8
     *
     * @param str
     * @return
     */
    public static String iso2UTF8(String str) {
        try {
            if (hasText(str)) return new String(str.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        return "";
    }

    public static String iso2GBK(String str) {
        try {
            if (hasText(str)) return new String(str.getBytes("ISO8859-1"), "GBK");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        return "";
    }

    /**
     * 将字符串转换为int
     *
     * @param str          字符�?
     * @param defaultValue 转换失败返回的默认�??
     * @return 转换成功返回指定值，失败返回默认�?
     */
    public static int str2Int(String str, int defaultValue) {
        try {
            return (hasText(str)) ? Integer.parseInt(str.trim()) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将字符串转换为long
     *
     * @param str          字符�?
     * @param defaultValue 转换失败返回的默认�??
     * @return 转换成功返回指定值，失败返回默认�?
     */
    public static long str2Long(String str, long defaultValue) {
        try {
            return (hasText(str)) ? Long.parseLong(str.trim()) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将字符串转换为float
     *
     * @param str          字符�?
     * @param defaultValue 转换失败返回的默认�??
     * @return 转换成功返回指定值，失败返回默认�?
     */
    public static float str2Float(String str, float defaultValue) {
        try {
            return (hasText(str)) ? Float.parseFloat(str.trim()) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将字符串转换为double
     *
     * @param str          字符�?
     * @param defaultValue 转换失败返回的默认�??
     * @return 转换成功返回指定值，失败返回默认�?
     */
    public static double str2Double(String str, double defaultValue) {
        try {
            return (hasText(str)) ? Double.parseDouble(str.trim()) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }


    public static boolean contains(String[] strs, String search) {
        if (strs == null || strs.length <= 0) return false;
        for (String str : strs) {
            if (str.equals(search)) return true;
        }
        return false;
    }

    public static String float2Str(Float f) {
        return (f == null) ? "" : f.toString();
    }

    public static String integer2Str(Integer i) {
        return (i == null) ? "" : i.toString();
    }

    public static String getFileNameByPath(String filePath) {
        if (!StringTools.hasText(filePath)) return filePath;
        return filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());
    }

    /**
     * 去除前后的指定字�?
     *
     * @param str
     * @param c
     * @return
     */
    public static String trim(String str, char c) {
        String trimLeading = trimLeadingCharacter(str, c);
        return trimTrailingCharacter(trimLeading, c);
    }
/*
    */
/*
    *//**//*
	public static String toLogString(String log, Object... args)
	{
		if (!hasText(log) || args == null) return log;
		String rs = log;
		for (Object arg : args)
		{
			String rm = arg == null ? "null" : arg.toString();
			if (arg != null) rm = rm.replace("{}", HOLDER);
			rs = rs.replaceFirst("\\{\\}", rm);
		}
		return rs.replace(HOLDER, "{}");
	}*/
    public static String toLogString(Object... params) {
        if (params == null) {
            throw new NullPointerException("params is null");
        }

        StringBuilder builder = new StringBuilder();
        builder.append(DateUtils.formatDate(new Date(), "yyyy.MM.dd HH:mm:ss") + "|");
        for (int i = 0; i < params.length - 1; i++) {
            builder.append(params[i]).append("|");
        }
        builder.append(params[params.length - 1]);
        return builder.toString();
    }
}
