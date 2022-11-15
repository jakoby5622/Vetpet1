package com.santotomas.vetpet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
/*
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer ();
        tiempo.schedule(tarea,5000);*/

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView somostxt = findViewById(R.id.txt_Vetpet);
        TextView tomasinotxt = findViewById(R.id.txt_tuvet);
        ImageView imagen = findViewById(R.id.imageView2);

        somostxt.setAnimation(animacion2);
        tomasinotxt.setAnimation(animacion2);
        imagen.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent =  new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }, 4000);


    }
}