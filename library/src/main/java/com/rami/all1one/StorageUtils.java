package com.rami.all1one;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;

import java.util.Collections;
import java.util.Set;

public class StorageUtils {


    public static boolean sdDisponible(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }
    public static boolean sdSoloLectura(){
        String estado= Environment.getExternalStorageState();
        if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            return true;
        }
        return false;
    }













    public static class sharedPreferences{

        private static SharedPreferences getShared(Context context){
           return  PreferenceManager.getDefaultSharedPreferences(context);
        }

        public static void save(Context context,String clave,String valor){
            getShared(context).edit().putString(clave, valor)
                       .apply();
        }
        public static void save(Context context,String clave,boolean valor){
            getShared(context).edit().putBoolean(clave, valor)
                    .apply();
        }
        public static void save(Context context,String clave,int valor){
            getShared(context).edit().putInt(clave, valor)
                    .apply();
        }
        public static void save(Context context,String clave,float valor){
            getShared(context).edit().putFloat(clave, valor)
                    .apply();
        }
        public static void save(Context context,String clave,long valor){
            getShared(context).edit().putLong(clave, valor)
                    .apply();
        }
        public static void save(Context context,String clave,Set<String> valor){
            getShared(context).edit().putStringSet(clave, valor)
                    .apply();
        }

        public static String getString(Context context,String clave){
            return getShared(context).getString(clave, "");
        }
        public static boolean getBoolean(Context context,String clave){
            return getShared(context).getBoolean(clave, false);
        }
        public static int getInt(Context context,String clave){
            return getShared(context).getInt(clave, 0);
        }
        public static boolean getFloat(Context context,String clave){
            return getShared(context).getBoolean(clave, false);
        }
        public static long getLong(Context context,String clave){
            return getShared(context).getLong(clave, 0);
        }
        public static Set<String> getSet(Context context, String clave){
            return getShared(context).getStringSet(clave, Collections.<String>emptySet());
        }
        public static void registerChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener){
         getShared(context).registerOnSharedPreferenceChangeListener(listener);
        }
        public static void removeChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener){
            getShared(context).unregisterOnSharedPreferenceChangeListener(listener);
        }
    }
}
