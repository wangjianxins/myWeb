package com.wangjianxin.util;

public class JsonResult {
    /**
     * 标示：1 成功 ； 非1为失败； 99: 数据库异常；88 网络异常； 66:对象不存在 ；55: 用户未登录；-1 未知错误 ；
     */
    public static final int OBJECT_NOT_EXIST = 66;
    public static final int SUCCESS = 1;
    public static final int USER_NOT_LOGIN = 55;
    public static final int DB_ERROR = 99;
    public static final int NET_ERROR = 88;
    public static final int UNKNOWN_ERROR = -1;

    private int a;
    private String b;
    private Object c;

    public JsonResult(int a, String b, Object c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Object getC() {
        return c;
    }

    public void setC(Object c) {
        this.c = c;
    }
}
