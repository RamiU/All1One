package com.rami.all1one;

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

public class Notificaciones {


        public static void simpleNotification(Activity activity,int icon) {

            /**Id for Notification**/
            int notifyId = 001;

            /**Gets an instance of the NotificationManager service**/
            NotificationManager mNotificationManager = (NotificationManager)activity.getSystemService(Context.NOTIFICATION_SERVICE);

            /**Get an instance of NotificationManager**/
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(activity)
                            .setSmallIcon(icon)
                            .setContentTitle("My notification")
                            .setAutoCancel(true)
                            .setContentText("Hello Developers!, Click to Dismiss");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                String channelId1 = "1";
                String channelName1 = "channel1";

                NotificationChannel channel = new NotificationChannel(channelId1, channelName1, NotificationManager.IMPORTANCE_DEFAULT);

                channel.enableLights(true);
                channel.setLightColor(Color.RED);
                channel.setShowBadge(true);
                channel.enableVibration(true);

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
            Intent intent = activity.getIntent();

            /**Create a TaskStackBuilder**/
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(activity);

            /**Add NextIntent**/
            stackBuilder.addNextIntent(intent);
            PendingIntent pendingIntent = stackBuilder.getPendingIntent(001, PendingIntent.FLAG_UPDATE_CURRENT);

            /**Set a Content Intent to Open on Notification Click**/
            builder.setContentIntent(pendingIntent);

            /*** When you issue multiple notifications about the same type of event,
             * it’s best practice for your app to try to update an existing notification
             * with this new information, rather than immediately creating a new notification.
             * If you want to update this notification at a later date, you need to assign it an ID.
             * You can then use this ID whenever you issue a subsequent notification.
             * If the previous notification is still visible, the system will update this existing notification,
             * rather than create a new one. In this example, the notification’s ID is 001***/


            if (mNotificationManager != null)
                mNotificationManager.notify(notifyId, builder.build());

        }

}
