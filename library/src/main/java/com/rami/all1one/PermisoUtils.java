package com.rami.all1one;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermisoUtils {

    public static boolean isGranted(Context context, String permiso){

           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
               return context.checkSelfPermission(permiso) == PackageManager.PERMISSION_GRANTED;
           }
       else
           return ContextCompat.checkSelfPermission(context,permiso) == PackageManager.PERMISSION_GRANTED;

    }
    public static void askPermissions(Activity activity,int requestCode, String... permissions){
       ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

}
