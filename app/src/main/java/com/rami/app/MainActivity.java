package com.rami.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.rami.all1one.DatabaseUtils;

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
