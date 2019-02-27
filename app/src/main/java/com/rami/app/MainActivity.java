package com.rami.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.rami.all1one.DatabaseUtils;
import com.rami.all1one.DeviceUtils;
import com.rami.all1one.EncriptacionUtils;
import com.rami.all1one.NetworkUtils;
import com.rami.all1one.PantallaUtils;
import com.rami.all1one.PermisoUtils;
import com.rami.all1one.SensorUtils;
import com.rami.all1one.StorageUtils;
import com.rami.all1one.adapters.AdaptadorUtils;
import com.rami.all1one.adapters.interfaces.IRecyclerCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity{
 private ArrayList<String> list = new ArrayList<>();

    public  class hold extends RecyclerView.ViewHolder{
        public View view;
        public hold(@NonNull View itemView) {
            super(itemView);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}

