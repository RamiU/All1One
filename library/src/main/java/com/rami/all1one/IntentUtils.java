package com.rami.all1one;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

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
}
