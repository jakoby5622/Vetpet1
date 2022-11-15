package com.santotomas.vetpet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ejemplos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplos);
    }

    public void SiguienteACT (View v){
        Intent inte = new Intent(this, Activity2.class);
        startActivity(inte);

    }

    public void formu (View form){
        Intent inte2 = new Intent(this, Activity3.class);
        startActivity(inte2);

    }

    public void IrContacto (View form){
        Intent inte3 = new Intent(this,Contacto.class);
        startActivity(inte3);

    }
    public void IrEjemplos (View form){
        Intent inte9 = new Intent(this,Ejemplos.class);
        startActivity(inte9);

    }
    public void IrMapas (View form){
        Intent inte4 = new Intent(this,MapsActivity.class);
        startActivity(inte4);

    }

    public void IrActividades (View actividades){
        Intent inte5 = new Intent(this, Activitythreads.class);
        startActivity(inte5);

    }

    public void IrSensores (View Sensor){
        Intent inte6 = new Intent(this,Sensores.class);
        startActivity(inte6);
    }
    public void IrCRUD (View MainActivityCRUD){
        Intent inte7 = new Intent(this,MainActivityCRUD.class);
        startActivity(inte7);
    }
    public void IrGiroscopio (View Giroscopio){
        Intent inte8 = new Intent(this,Giroscopio.class);
        startActivity(inte8);
    }
}
