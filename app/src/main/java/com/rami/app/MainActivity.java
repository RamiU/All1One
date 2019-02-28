package com.rami.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.DataSource;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.rami.all1one.AlertaUtils;
import com.rami.all1one.RetrofitUtils;
import com.rami.all1one.ScreenUtils;
import com.rami.all1one.SecurityUtils;
import com.rami.all1one.adapters.AdaptadorUtils;
import com.rami.all1one.adapters.interfaces.IPagedListCallBack;

import java.util.ArrayList;

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

