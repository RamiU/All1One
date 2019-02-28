package com.rami.all1one;

import android.app.Activity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

public class PermisoUtils {

    public static void pedirPermiso(Activity activity,String permiso){
        Dexter.withActivity(activity).withPermission(permiso);
    }
    public static void pedirPermiso(Activity activity, String permiso, PermissionListener listener){
        Dexter.withActivity(activity).withPermission(permiso).withListener(listener)
                         .check();
    }
    public static void pedirMultiplesPermisos(Activity activity,String... permisos ){
        Dexter.withActivity(activity)
                .withPermissions(permisos);
    }
    public static void pedirMultiplesPermisos(Activity activity, MultiplePermissionsListener listener, String... permisos){
        Dexter.withActivity(activity)
                .withPermissions(permisos)
                .withListener(listener)
                .check();
    }

}
