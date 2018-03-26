package com.example.macintosh.myduolingo.storage.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Stephany Daneri on 3/25/18.
 */

public class PreferencesHelper {

    private static final String DUOLINGO_PREFERENCES = "duolingoPreferences";
    private static final String PREFERENCES_USERNAME = DUOLINGO_PREFERENCES + ".username";
    private static final String PREFERENCES_PASSWORD = DUOLINGO_PREFERENCES + ".password";
    private static final String PREFERENCES_TOKEN = DUOLINGO_PREFERENCES + ".token";
    private static final String PREFERENCES_LANG = DUOLINGO_PREFERENCES + ".chosenLang";

    private PreferencesHelper() {
        //no instance
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(DUOLINGO_PREFERENCES, Context.MODE_PRIVATE);
    }



    public static void saveBLSession(Context context,String username,String token)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_USERNAME, username);
        editor.putString(PREFERENCES_TOKEN, token);
        editor.apply();
    }

    public static void saveChosenLang(Context context, String chosenLanguage){
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_LANG, chosenLanguage);
        editor.apply();

    }


//    public static void saveSession(Context context,String username,String password)
//    {
//        SharedPreferences.Editor editor = getEditor(context);
//        editor.putString(PREFERENCES_USERNAME, username);
//        editor.putString(PREFERENCES_PASSWORD, password);
//        editor.apply();
//    }


    public static void signOut(Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(PREFERENCES_USERNAME);
        editor.remove(PREFERENCES_PASSWORD);
        editor.apply();
    }


//    public static String getUserSession(Context context)
//    {
//        SharedPreferences sharedPreferences = getSharedPreferences(context);
//        String username= sharedPreferences.getString(PREFERENCES_USERNAME,null);
//
//        return username;
//    }
//
//    public static String getTokenSession(Context context)
//    {
//        SharedPreferences sharedPreferences = getSharedPreferences(context);
//        String token= sharedPreferences.getString(PREFERENCES_TOKEN,null);
//
//        return token;
//    }
//
//    public static boolean isSignedIn(Context context) {
//        final SharedPreferences preferences = getSharedPreferences(context);
//        return preferences.contains(PREFERENCES_USERNAME);
//    }
//

}

