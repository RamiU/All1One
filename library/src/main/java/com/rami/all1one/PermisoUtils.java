package com.rami.all1one;

import android.app.Activity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.single.PermissionListener;

import androidx.core.app.ActivityCompat;

public class PermisoUtils {

    public static void pedirPermiso(Activity activity,String permiso){
        Dexter.withActivity(activity).withPermission(permiso);
    }
    public static void pedirPermiso(Activity activity, String permiso, PermissionListener listener){
        Dexter.withActivity(activity).withPermission(permiso).withListener(listener)
                         .check();
    }

}
