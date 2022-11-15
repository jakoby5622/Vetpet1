package com.santotomas.vetpet;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Actividadgiroscopio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplos);
    }
    public void openProximity(View view) {
        startActivity(new Intent(Actividadgiroscopio.this,ProximityActivity.class));
    }
    public void openGyroscope(View view) {
        startActivity(new Intent(Actividadgiroscopio.this,Giroscopio.class));
    }
    public void openRotationVector(View view) {
        startActivity(new Intent(Actividadgiroscopio.this,RotationVectorActivity.class));
    }
}
