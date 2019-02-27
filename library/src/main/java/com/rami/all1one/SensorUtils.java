package com.rami.all1one;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.List;

public class SensorUtils {

    private SensorEventListener listener;
    private SensorManager manager;

    private SensorUtils(Activity activity,SensorEventListener listener) {
        this.manager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
        this.listener = listener;
    }
    public static SensorUtils newInstancia(Activity activity,SensorEventListener listener) {
        return new SensorUtils(activity,listener);
    }


    public  void registrarListener(Sensor sensor){
         this.manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public  void removerListener(){
        if(listener != null)
           this.manager.unregisterListener(listener);
    }

    public Sensor getSensor(int tipoSensor){
        return this.manager.getDefaultSensor(tipoSensor);
    }

    public boolean sensorDisponible(int tipoSensor){
        return this.manager.getDefaultSensor(tipoSensor) != null;
    }

    public List<Sensor> getAllSensors(){
        return this.manager.getSensorList(Sensor.TYPE_ALL);
    }


}
