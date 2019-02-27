package com.rami.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.View;

import com.rami.all1one.DatabaseUtils;
import com.rami.all1one.SensorUtils;
import com.rami.all1one.StorageUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
 private ArrayList<String> list = new ArrayList<>();
View view;

    class holder extends RecyclerView.ViewHolder{
        public String s;
        public holder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
