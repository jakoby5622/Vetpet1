package com.santotomas.vetpet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contacto extends Activity {

    private EditText textNombre;
    private EditText textApellido;
    private EditText textCorreo;
    private EditText textMensaje;
    private Button   btn_enviar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        textNombre = (EditText) findViewById(R.id.texNombre);
        textApellido = (EditText) findViewById(R.id.textApellido);
        textCorreo = (EditText) findViewById(R.id.textCorreo);
        textMensaje = (EditText) findViewById(R.id.textMensaje);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!textNombre.getText().toString().isEmpty()  && !textApellido.getText().toString().isEmpty() && !textCorreo.getText().toString().isEmpty() && !textMensaje.getText().toString().isEmpty()  ){
                    Intent intent = new Intent(Contacto.this, MFcontact.class);
                    intent.putExtra("nombre", textNombre.getText().toString());
                    intent.putExtra("apellido", textApellido.getText().toString());
                    intent.putExtra("correo", textCorreo.getText().toString());
                    intent.putExtra("mensaje", textMensaje.getText().toString());
                    startActivity(intent);
                } else{
                    Toast.makeText(Contacto.this, "Debes completar los datos", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}