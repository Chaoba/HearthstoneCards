package cn.com.mushuichuan.heartstonecards.util;

import java.util.Locale;

/**
 * Created by Liyanshun on 2016/2/18.
 */
public class Util {

    public static String getCurrentLauguage(){
        String mCurrentLanguage = Locale.getDefault().getLanguage();
        return mCurrentLanguage;
    }
}
