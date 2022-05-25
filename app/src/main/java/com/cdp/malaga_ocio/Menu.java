package com.cdp.malaga_ocio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cdp.malaga_ocio.entidades.Usuario;
import com.cdp.malaga_ocio.entidades.daoUsuario;

public class Menu extends AppCompatActivity {

    TextView tv_nombre;
    Button  btnUbicaciones,  btnCancelar, btnFavs;
    ImageButton btnRestaurantes, btnPubs, btnDiscotecas, btnTurismo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnFavs = (Button) findViewById(R.id.btnFavs);
        btnRestaurantes = (ImageButton) findViewById(R.id.btnRestaurantes);
        btnPubs = (ImageButton) findViewById(R.id.btnPubs);
        btnDiscotecas = (ImageButton) findViewById(R.id.btnDiscotecas);
        btnTurismo = (ImageButton) findViewById(R.id.btnTurismo);


        Bundle b = getIntent().getExtras();
        String data = b.getString("username");
        tv_nombre.setText("Hola, " + data);

        btnRestaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, listaRestaurantes.class);
                startActivity(i);

            }
        });

        btnPubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, listaPubs.class);
                startActivity(i);

            }
        });

        btnDiscotecas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, listaDiscotecas.class);
                startActivity(i);

            }
        });

        btnTurismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, listaTurismo.class);
                startActivity(i);

            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(Menu.this, MainActivity.class);
                    startActivity(i);
                    finish();
            }
        });

        btnFavs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, mostrarFavoritos.class);
                startActivity(i);
            }
        });
    }
}