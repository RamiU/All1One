package com.rami.all1one;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;

import java.util.Calendar;
import java.util.Date;

import static android.content.Context.ALARM_SERVICE;

public class TimeUtils {

    public static long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }
    public static Calendar getCalendar(){
        return Calendar.getInstance();
    }


    public static void AlarmManagerRepetitivo(Activity activity, Class<? extends BroadcastReceiver> broadCast){
        //System.currentTimeMillis() devuelve la hora exacta , por lunes ejemplo 7 de enero 2019 11:09 am
        AlarmManager manager = (AlarmManager) activity.getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(activity,broadCast);// el broadcast a ejecutar
        PendingIntent pendingIntent = PendingIntent.getBroadcast(activity,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        int tipoAlarma = AlarmManager.RTC;

        long inicio = System.currentTimeMillis();
        int intervalo = 60 * 1000;
        //manager.setInexactRepeating(, , , );
        manager.setRepeating(tipoAlarma,inicio,intervalo, pendingIntent);

    }
    public static void AlarmManagerUnaVez(Activity activity,Class<? extends BroadcastReceiver> broad,Calendar fechaEvento){
        //System.currentTimeMillis() devuelve la hora exacta , por lunes ejemplo 7 de enero 2019 11:09 am
        AlarmManager manager = (AlarmManager) activity.getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(activity,broad);// el broadcast a ejecutar
        PendingIntent pendingIntent = PendingIntent.getBroadcast(activity,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar calendar = Calendar.getInstance();
        //calendar.setTimeInMillis(calendarView.getDate());
        calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+1);
        manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);


    }
}
