package com.cdp.malaga_ocio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cdp.malaga_ocio.entidades.Favorito;
import com.cdp.malaga_ocio.entidades.Usuario;
import com.cdp.malaga_ocio.entidades.daoFavorito;
import com.cdp.malaga_ocio.entidades.daoUsuario;

public class agregarFavorito extends AppCompatActivity implements View.OnClickListener {

    EditText et__nombresitio, et__ubicacion;
    Button btnReg__sitio, btnMenu;
    daoFavorito dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_favorito);

        et__nombresitio=(EditText) findViewById(R.id.et__nombresitio);
        et__ubicacion=(EditText) findViewById(R.id.et__ubicacion);
        btnReg__sitio=(Button) findViewById(R.id.btnReg__sitio);
        btnMenu=(Button) findViewById(R.id.btnMenu);
        dao= new daoFavorito(this);

        btnReg__sitio.setOnClickListener(this);
        btnMenu.setOnClickListener(this);

        String nombre = getIntent().getStringExtra("nombre");
        String ubicacion = getIntent().getStringExtra("ubicacion");

        et__nombresitio.setText(nombre);
        et__ubicacion.setText(ubicacion);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReg__sitio:
                Favorito f = new Favorito();
                f.setNombre(et__nombresitio.getText().toString());
                f.setUbicacion(et__ubicacion.getText().toString());
                if(!f.isNull()) {
                    Toast.makeText(this, "ERROR: campos vacios!", Toast.LENGTH_LONG).show();
                }else if (dao.insertFavorito(f)) {
                    Intent i = new Intent(agregarFavorito.this, mostrarFavoritos.class);
                    startActivity(i);
                    Toast.makeText(this, "Lugar agregado a favoritos!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Este lugar ya ha sido añadido a favoritos!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnMenu:
                Intent i = new Intent(agregarFavorito.this, mostrarFavoritos.class);
                startActivity(i);
                break;
        }

    }
}