package com.bruce.tomorrownews.util;

import android.util.Log;

/**
 * Created by Administrator on 2015-12-02.
 */
public class Logs {
    private static String tag = "测试";
    private static boolean flag = true;

    public static void v(String msg) {
        if (flag) {
            Log.v(tag, msg);
        }
    }

    public static void d(String msg) {
        if (flag) {
            Log.d(tag, msg);
        }
    }

    public static void i(String msg) {
        if (flag) {
            Log.i(tag, msg);
        }
    }

    public static void w(String msg) {
        if (flag) {
            Log.w(tag, msg);
        }
    }

    public static void e(String msg) {
        if (flag) {
            Log.e(tag, msg);
        }
    }
}
