package com.rami.all1one;

import android.app.Activity;

import androidx.core.app.ActivityCompat;

public class PermisoUtils {
    public interface PermissionsCallback{  }

    public static void pedirPermiso(Activity activity,int idRequest,String... permisos){
        ActivityCompat.requestPermissions(activity,
                permisos,idRequest);


    }

}
