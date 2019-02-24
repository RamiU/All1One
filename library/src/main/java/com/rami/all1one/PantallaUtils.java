package com.rami.all1one;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * CREADO POR RAMY
 */
public final class PantallaUtils {
   private PantallaUtils(){}

    public static void setPortrait(Activity activity){
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public static boolean isPortrait(Activity activity) {
        return activity.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
    }
    public static void setLandscape(Activity activity){
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public static boolean isLandscape(Activity activity) {
        return activity.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }




    public static void setFullScreen(Activity activity){
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                           WindowManager.LayoutParams.FLAG_FULLSCREEN );
    }

    /**
     * hace que la barra de estado del dispositivo sea transparente esto solo es posible
     * en dispositivos con android 21 en adelante
     */
    public static void setStatusBarTransparente(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
