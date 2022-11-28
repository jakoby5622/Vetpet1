package com.santotomas.vetpet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {
    private CheckBox seleccionarChk;
    private DrawerLayout drawerLayout;
    private static final String TAG = "SensorsTutorial";
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListener;
    private Button btNotificacion;
    Button button2;
    EditText email, password;
    FirebaseAuth mAuth;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = email.getText().toString().trim();
                String passUser = password.getText().toString().trim();
                mAuth = FirebaseAuth.getInstance();

                // excepciones
                if (emailUser.isEmpty()&& passUser.isEmpty()){
                    Toast.makeText(MainActivity.this,"Ingresar datos",Toast.LENGTH_SHORT).show();

                }else{
                    loginUser(emailUser,passUser);

                }

            }
        });
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

    private void loginUser(String emailUser, String passUser) {
        mAuth.signInWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                        finish();
                        startActivity(new Intent(MainActivity.this, Ejemplos.class));
                    Toast.makeText(MainActivity.this,"Bienvenido a VetPet",Toast.LENGTH_SHORT).show();

                }else{Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,"Error al iniciar sesion",Toast.LENGTH_SHORT).show();
            }
        });
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