package com.santotomas.vetpet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private CheckBox seleccionarChk;
    private DrawerLayout drawerLayout;
    private static final String TAG = "SensorsTutorial";
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListener;
    private Button btNotificacion;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seleccionarChk = (CheckBox)findViewById(R.id.chkSeleccionar);

        // prueba sensor 3












        //Sensores de proximidad
        sensorManager = (SensorManager)
                getSystemService(SENSOR_SERVICE);
        // Using proximity sensor
        proximitySensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(proximitySensor == null) {
            Log.e(TAG, "Proximity sensor not available.");
            finish();
        }
        proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0] <
                        proximitySensor.getMaximumRange()) {



                    salir();
                }
                else {


                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

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
    //metodos de sensor de proximidad
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(proximitySensorListener,
                proximitySensor, 2 * 1000 * 1000);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(proximitySensorListener);
    }



    public void salir (){
        finishAffinity();
    }

}