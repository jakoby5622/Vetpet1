package com.santotomas.vetpet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ConstraintLayout Layout ;
    ImageView iv1;


    String [] country = {"seleccione sede","Santiago centro",
            "San Joaquin",
            "Arica",
            "Iquique",
            "Antofagasta",
            "Copiapo",
            "la serana",
            "Ovalle",
            "Viña del mar",
            "Rancagua",
            "Curico",
            "Talca",
            "Chillan",
            "concepcion",
            "Los angeles", "Temuco",
            "Valdivia",
            "Osorno",
            "Puerto Montt",
            "Punta Arenas",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        Layout = findViewById(R.id.Layout);
        iv1 = findViewById(R.id.iv1);


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void snack (View v2){
        Snackbar.make(Layout,"Datos guardados correctamente", Snackbar.LENGTH_LONG).setAction("Cerrar", new View.OnClickListener() {
            @Override
            public void onClick(View v3) {

            }
        })
                .setActionTextColor(getResources().getColor(R.color.purple_200)).show();

    }


    final int CAPTURA_IMAGEN=1;

    public void tomarFoto (View v){

        Intent i =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,CAPTURA_IMAGEN);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==CAPTURA_IMAGEN && resultCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap bitmap1 = (Bitmap)extras.get("data");
            iv1.setImageBitmap(bitmap1);

            try {
                FileOutputStream fos = openFileOutput(crearNombreArchivoJPG(), Context.MODE_PRIVATE);
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,fos);
                fos.close();

            }catch (Exception e){

            }

        }
    }

    private String crearNombreArchivoJPG() {
        String fecha= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return fecha+".jpg";
    }


    public void VerTodasLasFotos(View v){

        Intent intentfotos = new Intent(this, Fotos.class);
        startActivity(intentfotos);
    }

}