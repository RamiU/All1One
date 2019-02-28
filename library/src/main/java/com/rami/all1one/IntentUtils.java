package com.rami.all1one;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import androidx.annotation.IntDef;

public class IntentUtils {

    public static void abrirWeb(Activity activity,String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        activity.startActivity(i);
    }
    public static void abrirCorreo(Activity activity,String correo,String titulo){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",correo, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, titulo);
        activity.startActivity(Intent.createChooser(emailIntent, titulo));
    }

    public static void abrirVentanaShare(Activity activity,String titulo,String texto){
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, texto);
        activity.startActivity(Intent.createChooser(share, titulo));
    }
    public static void abrirActivity(Context context,String Setting){
            Intent intent = new Intent(Setting);
            //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
    }
}
