package demo.deepoon.com.downloaddatacopy;

import android.util.Log;

/**
 * Copyright © 2015上海乐相科技有限公司. All rights reserved.
 *
 * @ProjectName: CommonFramework
 * @ClassName: LogUtils
 * @Description: 日志工具类
 * @Author: tuo.jin  sheng(改了一点，可以一键关闭logUtils)
 * @CreateDate: 2015年12月12日
 * @UpdateUser:
 * @UpdateDate:
 * @UpdateRemark:
 */

public class LogUtils {
    public static boolean WRITE_LOG = true;

    public static boolean hasLogFile = false;

    private static String TAG = "LogUtils";

    private LogUtils() {
    }
	
	public static void setWriteLog(boolean isWritable){
        WRITE_LOG = isWritable;
    }

    @SuppressWarnings("unused")
    public static void v(String tag, String msg) {
        if (WRITE_LOG || hasLogFile) {
            String className = "";
            String logInfo = "";
            try {
                String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

            } catch (Exception e) {
                className = tag;
                logInfo = msg;
                Log.e(TAG, "log error");
            }

            if (tag == null || "".equals(tag)) {
                tag = className;
            }

            Log.v(tag, logInfo);
        }
    }

    @SuppressWarnings("unused")
    public static void v(String tag, String msg, Throwable tr) {
        if (WRITE_LOG || hasLogFile) {
            String className = "";
            String logInfo = "";
            try {
                String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

            } catch (Exception e) {
                className = tag;
                logInfo = msg;
                Log.e(TAG, "log error");
            }

            if (tag == null || "".equals(tag)) {
                tag = className;
            }

            Log.v(tag, logInfo, tr);
        }
    }

    @SuppressWarnings("unused")
    public static void d(String tag, String msg) {
        if (WRITE_LOG || hasLogFile) {
            String className = "";
            String logInfo = "";
            try {
                String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

            } catch (Exception e) {
                className = tag;
                logInfo = msg;
                Log.e(TAG, "log error");
            }

            if (tag == null || "".equals(tag)) {
                tag = className;
            }

            Log.d(tag, logInfo);
        }
    }

    @SuppressWarnings("unused")
    public static void d(String tag, String msg, Throwable tr) {
        if (WRITE_LOG || hasLogFile) {
            String className = "";
            String logInfo = "";
            String methodName = "";
            int lineNumber = 0;
            try {
                String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
                // 获取日志所在的行号
                lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

            } catch (Exception e) {
                className = tag;
                logInfo = msg;
                Log.e(TAG, "log error");
            }

            if (tag == null || "".equals(tag)) {
                tag = className;
            }

            Log.d(tag, logInfo, tr);
        }
    }

    @SuppressWarnings("unused")
    public static void i(String tag, String msg) {
        if (WRITE_LOG || hasLogFile) {
            String className = "";
            String logInfo = "";
            String methodName = "";
            int lineNumber = 0;
            try {
                String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
                // 获取日志所在的行号
                lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

            } catch (Exception e) {
                className = tag;
                logInfo = msg;
                Log.e(TAG, "log error");
            }

            if (tag == null || "".equals(tag)) {
                tag = className;
            }

            Log.i(tag, logInfo);
        }
    }

    @SuppressWarnings("unused")
    public static void i(String tag, String msg, Throwable tr) {
        if (WRITE_LOG || hasLogFile) {
            String className = "";
            String logInfo = "";
            try {
                String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

            } catch (Exception e) {
                className = tag;
                logInfo = msg;
                Log.e(TAG, "log error");
            }

            if (tag == null || "".equals(tag)) {
                tag = className;
            }

            Log.i(tag, logInfo, tr);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        String className = "";
        String logInfo = "";
        try {
            String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            // 获取打印日志所在的类名
            className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
            logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

        } catch (Exception e) {
            className = tag;
            logInfo = msg;
            Log.e(TAG, "log error");
        }

        if (tag == null || "".equals(tag)) {
            tag = className;
        }

        Log.e(tag, logInfo, tr);
    }

    public static void e(String tag, String msg) {
        String className = "";
        String logInfo = "";
        try {
            String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            // 获取打印日志所在的类名
            className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
            logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

        } catch (Exception e) {
            className = tag;
            logInfo = msg;
            Log.e(TAG, "log error");
        }

        if (tag == null || "".equals(tag)) {
            tag = className;
        }

        Log.e(tag, logInfo);
    }

    @SuppressWarnings("unused")
    public static void w(String tag, String msg) {
        if (WRITE_LOG || hasLogFile) {
            String className = "";
            String logInfo = "";
            try {
                String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

            } catch (Exception e) {
                className = tag;
                logInfo = msg;
                Log.e(TAG, "log error");
            }

            if (tag == null || "".equals(tag)) {
                tag = className;
            }

            Log.w(tag, logInfo);
        }
    }

    @SuppressWarnings("unused")
    public static void w(String tag, String msg, Throwable tr) {
        if (WRITE_LOG || hasLogFile) {
            String className = "";
            String logInfo = "";
            try {
                String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + msg;

            } catch (Exception e) {
                className = tag;
                logInfo = msg;
                Log.e(TAG, "log error");
            }

            if (tag == null || "".equals(tag)) {
                tag = className;
            }

            Log.w(tag, logInfo, tr);
        }
    }
}
