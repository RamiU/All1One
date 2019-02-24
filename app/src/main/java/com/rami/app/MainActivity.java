package com.rami.app;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import com.rami.all1one.AnimacionUtils;
import com.rami.all1one.NotificacionUtils;
import com.rami.all1one.PantallaUtils;

public class MainActivity extends AppCompatActivity {

View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /// view = findViewById(R.id.boton);

      // Animaciones.ocultar(view, 2000, ValueAnimator.INFINITE)
       // .start();
        //Animaciones.rotar(view,3000,360f,3).start();

        //Animaciones.trasladar(view,2,4000,400,400).start();


       // view.animate().setDuration(3000).alpha(0).setStartDelay(2000)
        //.alpha(1).rotation(180);







       ObjectAnimator mover = ObjectAnimator.ofFloat(view,
                "translationX", -500f, 0f);
        mover.setDuration(2000);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(view, "alpha",
                0f, 1f);
        fadeIn.setDuration(2000);
        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.play(mover).with(fadeIn);
        animatorSet.start();
    }
}
