package com.rami.all1one;

import android.os.Environment;

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
}
