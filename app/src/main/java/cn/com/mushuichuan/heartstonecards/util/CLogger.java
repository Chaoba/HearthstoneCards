package cn.com.mushuichuan.heartstonecards.util;

import android.util.Log;

import cn.com.mushuichuan.heartstonecards.BuildConfig;


public class CLogger {
    private static final String TAG = "CLogger";
    private static boolean mIsInnerShowLog = BuildConfig.DEBUG;
    private static String CLASS_NAME = null;

    private static String getFunctionName() {
        if (CLASS_NAME == null) {
            CLASS_NAME = CLogger.class.getName();
        }
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }
        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(CLASS_NAME)) {
                continue;
            }
            return st.getFileName() + "[Line: " + st.getLineNumber() + "] ";
        }
        return null;
    }

    @Deprecated
    public static void i(String tag, Object message) {
        String name = getFunctionName();
        if (mIsInnerShowLog) {
            if (name == null) {
                Log.i(tag, message.toString());
            } else {
                Log.i(tag, name + message.toString());
            }
        }
    }

    public static void i(Object message) {
        i(TAG, message);
    }

    @Deprecated
    public static void d(String tag, Object message) {
        String name = getFunctionName();
        if (mIsInnerShowLog) {
            if (name == null) {
                Log.d(tag, message.toString());
            } else {
                Log.d(tag, name + message.toString());
            }
        }
    }

    public static void d(Object message) {
        d(TAG, message);
    }

    @Deprecated
    public static void v(String tag, Object message) {
        String name = getFunctionName();
        if (mIsInnerShowLog) {
            if (name == null) {
                Log.v(tag, message.toString());
            } else {
                Log.v(tag, name + message.toString());
            }
        }
    }

    @Deprecated
    public static void v(Object message) {
        v(TAG, message);
    }

    @Deprecated
    public static void w(String tag, Object message) {
        String name = getFunctionName();
        if (mIsInnerShowLog) {
            if (name == null) {
                Log.w(tag, message.toString());
            } else {
                Log.w(tag, name + message.toString());
            }
        }
    }

    public static void w(Object message) {
        w(TAG, message);
    }

    @Deprecated
    public static void e(String tag, Object message) {
        String name = getFunctionName();
        if (mIsInnerShowLog) {
            if (name == null) {
                Log.e(tag, message.toString());
            } else {
                Log.e(tag, name + message);
            }
        }
    }

    public static void e(Object message) {
        e(TAG, message);
    }

    @Deprecated
    public static void e(String tag, Throwable e) {
        String name = getFunctionName();
        if (mIsInnerShowLog) {
            if (name == null) {
                Log.e(tag, e.getMessage());
            } else {
                Log.e(tag, name + e.getMessage());
            }
            e.printStackTrace();
        }
    }

    public static void e(Throwable e) {
        e(TAG, e);
    }

}
