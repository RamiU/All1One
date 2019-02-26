package com.rami.all1one;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AlertDialog;

public final class AlertaUtils{
    private AlertaUtils(){}


    public static ProgressDialog progressHorizontalDialog(Context context){

        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Actualizando");
        progressDialog.setMessage("Porfavor espere...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.getWindow().setGravity(Gravity.BOTTOM); // establece la posicion de la ventana
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        return progressDialog;

    }

    public static AlertDialog.Builder alertDialog(Context contexto){

        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle("");
        builder.setMessage("");
        builder.setCancelable(false);
        return builder;
    }

    public static void toast(Context context, String mensaje){
        Toast.makeText(context,mensaje, Toast.LENGTH_SHORT).show();
    }
}
