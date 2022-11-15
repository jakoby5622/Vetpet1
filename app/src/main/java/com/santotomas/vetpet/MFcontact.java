package com.santotomas.vetpet;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MFcontact extends Activity {

    private Bundle bundle;
    private Bundle bundle2;
    private Bundle bundle3;
    private Bundle bundle4;
    private TextView tvnombre;
    private TextView tvapellido;
    private TextView tvcorreo;
    private TextView tvmensaje;
    private Button btn_notificacion;
    private PendingIntent pendingIntent;
    private static final String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICATIOM_ID = 0;
    private View form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_for_contac);

        tvnombre = (TextView) findViewById(R.id.tvnombre);
        tvapellido = (TextView) findViewById(R.id.tvapellido);
        tvcorreo = (TextView) findViewById(R.id.tvcorreo);
        tvmensaje= (TextView) findViewById(R.id.tvmensaje);

        bundle = getIntent().getExtras();
        bundle2 = getIntent().getExtras();
        bundle3 = getIntent().getExtras();
        bundle4 = getIntent().getExtras();

        String nombre = bundle.getString("nombre");
        String apellido = bundle2.getString("apellido");
        String correo = bundle3.getString("correo");
        String mensaje = bundle4.getString("mensaje");

        tvnombre.append(" " + nombre );
        tvapellido.append(" " + apellido );
        tvcorreo.append(" " + correo );
        tvmensaje.append(" " + mensaje );

        btn_notificacion=findViewById(R.id.btn_notificacion);

        btn_notificacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick (View v) {
               createNotificationChannel();
               createNotification();
               IrPrincipal(form);

        }

        });



    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name,NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager)  getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    }


    public   void IrPrincipal (View form){
        Intent inte3 = new Intent(this,MainActivity.class);
        startActivity(inte3);
        Toast.makeText(MFcontact.this, "Gracias , te respondere a la brevedad", Toast.LENGTH_SHORT).show();
    }




    private void createNotification() {
        NotificationCompat.Builder builder  = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setSmallIcon(R.drawable.alerta);
        builder.setContentTitle("Notificacion");
        builder.setContentTitle("Se envio tu mensaje");
        builder.setColor(Color.BLUE);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICATIOM_ID,builder.build());


    }

}