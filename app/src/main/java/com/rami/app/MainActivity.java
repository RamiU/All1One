package com.rami.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.rami.all1one.AlertaUtils;
import com.rami.all1one.AnimacionUtils;
import com.rami.all1one.IntentUtils;
import com.rami.all1one.NotificacionUtils;
import com.rami.all1one.PantallaUtils;
import com.rami.all1one.RetrofitUtils;
import com.rami.all1one.SensorUtils;
import com.rami.all1one.adapters.AdaptadorUtils;
import com.rami.all1one.adapters.interfaces.IRecyclerCallback;
import com.rami.all1one.databases.DatabaseUtils;
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
