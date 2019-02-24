package com.rami.all1one;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;

public class NotificacionUtils {
    private NotificationManager mNotificationManager;
    private Activity mActivity;
    public NotificacionUtils(Activity activity){
        this.mActivity = activity;
        this.mNotificationManager
                =(NotificationManager)activity.getSystemService(Context.NOTIFICATION_SERVICE);
    }

       @TargetApi(Build.VERSION_CODES.O)
       private NotificationChannel notifCanal(String idCanal,String nombreCanal){
        NotificationChannel canal =
                new NotificationChannel(idCanal, nombreCanal, NotificationManager.IMPORTANCE_DEFAULT);

           canal.enableLights(true);
           canal.setLightColor(Color.RED);
           canal.setShowBadge(true);
           canal.enableVibration(true);
           return canal;
       }
        public  void simpleNotif(String titulo,String contenido,int icono) {
            int notifyId = 001;
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this.mActivity)
                            .setSmallIcon(icono)
                            .setContentTitle(titulo)
                            .setAutoCancel(true)
                            .setContentText(contenido);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String channelId1 = "1";
                String channelName1 = "channel1";
                NotificationChannel channel = this.notifCanal(channelId1, channelName1);

                builder.setChannelId(channelId1);
                if (mNotificationManager != null) {
                    mNotificationManager.createNotificationChannel(channel);
                }

            } else {

                builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
            }

            /**Use getIntent if you want to Open Current Activity
             * Else Use
             * Intent intent = new Intent(getApplicationContext, MyClass.class);
             * Use Your Class Name instead of MyClass**/
            Intent intent = this.mActivity.getIntent();

            /**Create a TaskStackBuilder**/
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this.mActivity);

            /**Add NextIntent**/
            stackBuilder.addNextIntent(intent);
            PendingIntent pendingIntent = stackBuilder.getPendingIntent(001, PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setContentIntent(pendingIntent);


            if (mNotificationManager != null)
                mNotificationManager.notify(notifyId, builder.build());

        }



}
