package com.rami.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.rami.all1one.AlertaUtils;
import com.rami.all1one.AnimacionUtils;
import com.rami.all1one.NotificacionUtils;
import com.rami.all1one.PantallaUtils;
import com.rami.all1one.RetrofitUtils;
import com.rami.all1one.adapters.Recycler;
import com.rami.all1one.adapters.interfaces.IRecyclerCallback;

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
             list.add("asdasd");
             list.add("asdasd");
        //Recycler<holder,String> a = new Recycler<>(list,this);

        /// view = findViewById(R.id.boton);

      // Animaciones.ocultar(view, 2000, ValueAnimator.INFINITE)
       // .start();
        //Animaciones.rotar(view,3000,360f,3).start();

        //Animaciones.trasladar(view,2,4000,400,400).start();


       // view.animate().setDuration(3000).alpha(0).setStartDelay(2000)
        //.alpha(1).rotation(180);






    }
}
