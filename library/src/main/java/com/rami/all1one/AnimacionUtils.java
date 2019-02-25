package com.rami.all1one;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;


import androidx.annotation.IntDef;

public final class AnimacionUtils {
      private AnimacionUtils(){}

    public  static ObjectAnimator ocultar(View view, long duracion,int nRepeat){
       // PropertyValuesHolder x = PropertyValuesHolder.ofFloat()
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(view, View.ALPHA,
                0f,1f);
        fadeOut.setDuration(duracion);
        fadeOut.setRepeatMode(ValueAnimator.REVERSE);

        fadeOut.setRepeatCount(nRepeat);

        //fadeOut.start();
        return fadeOut;
    }
    public static ObjectAnimator trasladar(View view,int nRepeat,int duracion,float posX,float posY){

        PropertyValuesHolder trasX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X,0,posX);
        PropertyValuesHolder trasY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y,0,posY);

        ObjectAnimator trasladar = ObjectAnimator.ofPropertyValuesHolder(view, trasX,trasY);
        trasladar.setDuration(duracion);
        trasladar.setInterpolator(new AccelerateDecelerateInterpolator());
        trasladar.setRepeatCount(nRepeat);
        trasladar.setRepeatMode(ValueAnimator.REVERSE);
       // trasladar.start();
        return trasladar;
    }


    public  static ObjectAnimator rotar(View view,int duracion,float rotacion,int nRepeticion){
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(view,
                View.ROTATION, rotacion);
        rotationAnimator.setDuration(duracion);
        rotationAnimator.setRepeatMode(ValueAnimator.REVERSE);
        rotationAnimator.setRepeatCount(nRepeticion);
        return rotationAnimator;
    }
    public  void SimpleRotacion(View view,float rotacion,int duracion,boolean isGradual) {
        view.animate().rotation(rotacion).setDuration(duracion).
        setInterpolator(isGradual ? new AccelerateDecelerateInterpolator() : null)
        .start();
    }

    public static void Simplealpha(View view) {
        view.animate().alpha(0).start();
    }
    public static void SimpleScale(View view,int duracion,float escalaX,float escalaY) {

        view.animate().scaleX(escalaX).setDuration(duracion).scaleY(escalaY)
        .setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animation.start();
            }
        });
    }

    public static void Simpletranslate(View view,int posX,int posY,long duracion) {
        view.animate().translationX(posX).translationY(posY)
                .setDuration(duracion)
                .start();

    }

    /**
     *
     * @param repetir true si desea que este set se repita indefinidamente
     * @param animacion una lista de animacion
     */
    public static void animationSet(final boolean repetir, final Animator... animacion){

        AnimatorSet animatorSet = new AnimatorSet();

            AnimatorSet.Builder  builder = animatorSet.play(animacion[0]);
            for (int i = 1; i < animacion.length; i++)
                builder.before(animacion[i]);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                if (repetir)
                    animation.start();
            }
        });
        animatorSet.start();

    }
}
