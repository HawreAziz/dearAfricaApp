package utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;


public class LocaleHelper {

    public static void changeLanguage(String language, Resources res){
        String lang = language.equals("Swedish") ? "se" : "en";
        Locale myLocale = new Locale(lang);
        DisplayMetrics displayMetrics = res.getDisplayMetrics();
        Configuration configuration = res.getConfiguration();
        configuration.locale = myLocale;
        res.updateConfiguration(configuration, displayMetrics);
    }
}