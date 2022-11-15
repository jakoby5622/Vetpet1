package com.santotomas.vetpet;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox seleccionarChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seleccionarChk = ( CheckBox)findViewById(R.id.chkSeleccionar);
    }

    public void SiguienteACT (View v){
        Intent inte = new Intent(this, Activity2.class);
        startActivity(inte);

    }

    public void formu (View form){
        Intent inte2 = new Intent(this, Activity3.class);
        startActivity(inte2);

    }


    public void btnCheck (View v){

        if (seleccionarChk.isChecked()==true){
            String mensaje = "credenciales guardadas";
            Toast toast = Toast.makeText(this,"credenciales guardadas",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START,90,0);
            toast.show();

        }
        else{
            String mensaje = "credenciales no guardadas";
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
        }

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

}