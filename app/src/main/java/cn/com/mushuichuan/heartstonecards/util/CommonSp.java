package cn.com.mushuichuan.heartstonecards.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;


public class CommonSp {
    @Inject
    Context mContext;
    private static final String TAG_COMMON = "TAG_COMMON";

    private SharedPreferences COMMON_PREFERENCES;

    private CommonSp() {
        COMMON_PREFERENCES = mContext.getSharedPreferences(TAG_COMMON, 0);
    }


    private static CommonSp commonSp;

    public synchronized static CommonSp getInstance() {
        if (commonSp == null) {
            commonSp = new CommonSp();
        }
        return commonSp;
    }


    /*conmmon content*/
    public static ArrayList<String> getHistoryList(String key) {
        HashSet<String> set = (HashSet<String>) commonSp.internalGetSet(key);
        ArrayList list = new ArrayList(set);
        return list;
    }

    public static String getCommonString(String key) {
        String string = commonSp.internalGetCommonString(key);
        CLogger.i("key:" + key + "----value:" + string);
        return string;
    }

    public static void saveCommonString(String key, String value) {
        commonSp.interalSaveCommonString(key, value);
    }

    public static Integer getCommonInt(String key) {
        Integer integer = commonSp.internalGetCommonInt(key);
        CLogger.i("key:" + key + "----value:" + integer);
        return integer;
    }

    public static void saveCommonInt(String key, Integer value) {
        commonSp.internalSaveCommonInt(key, value);
    }

    private String internalGetCommonString(String key) {
        return COMMON_PREFERENCES.getString(key, "");
    }

    private Set<String> internalGetSet(String key) {
        return COMMON_PREFERENCES.getStringSet(key, new HashSet<String>() {
        });
    }

    private void interalSaveSet(String key, String value) {
        HashSet set = (HashSet) internalGetSet(key);
        set.add(value);
        COMMON_PREFERENCES.edit().putStringSet(key, set).commit();
    }

    private void interalSaveCommonString(String key, String value) {
        COMMON_PREFERENCES.edit().putString(key, value).commit();
    }

    private Integer internalGetCommonInt(String key) {
        return COMMON_PREFERENCES.getInt(key, 0);
    }

    private void internalSaveCommonInt(String key, Integer value) {
        COMMON_PREFERENCES.edit().putInt(key, value).commit();
    }

}
