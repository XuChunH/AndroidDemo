package ch.xch.androiddemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by XCH on 2014/12/3.
 */
public class SharedPreferencesUtil {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SharedPreferencesUtil(Context context) {
        sp = context.getSharedPreferences(Constant.TEXT_SETTING, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public int getTheme() {
        return sp.getInt(Constant.TEXT_THEME, Constant.THEME_DARK);
    }

    public void setTheme(int theme) {
        editor.putInt(Constant.TEXT_THEME, theme);
        editor.commit();
    }

}
