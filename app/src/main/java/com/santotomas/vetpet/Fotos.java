package com.santotomas.vetpet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileInputStream;

public class Fotos extends AppCompatActivity {
String [] archivos;
RecyclerView rv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_fotos);
        archivos=fileList();
        rv2=findViewById(R.id.rv2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv2.setLayoutManager(linearLayoutManager);
        rv2.setAdapter(new AdaptadorFotos());


    }

    private class AdaptadorFotos extends RecyclerView.Adapter<AdaptadorFotos.AdaptadorFotosHolder> {

        @NonNull
        @Override
        public AdaptadorFotosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorFotosHolder(getLayoutInflater().inflate(R.layout.layout_fotos,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorFotosHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return archivos.length;
        }


        class AdaptadorFotosHolder extends RecyclerView.ViewHolder{
            ImageView iv1;
            TextView tv1;

            public AdaptadorFotosHolder(@NonNull View itemView) {
                super(itemView);
                tv1=itemView.findViewById(R.id.tvfoto);
                iv1=itemView.findViewById(R.id.ivfoto);


            }

            public void imprimir(int position) {
                tv1.setText("nombre del archivo :"+archivos[position]);
                try{

                    FileInputStream fileInputStream =  openFileInput(archivos[position]);
                    Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                    iv1.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }
    }
}