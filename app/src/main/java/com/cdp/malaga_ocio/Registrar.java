package com.cdp.malaga_ocio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cdp.malaga_ocio.entidades.Usuario;
import com.cdp.malaga_ocio.entidades.daoUsuario;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
EditText us, pas, nom, ap;
Button reg, can;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        us=(EditText) findViewById(R.id.usuario);
        pas=(EditText) findViewById(R.id.contraseña);
        nom=(EditText) findViewById(R.id.nombre);
        ap=(EditText) findViewById(R.id.apellidos);
        reg=(Button) findViewById(R.id.btnReg);
        can=(Button) findViewById(R.id.btnCan);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao= new daoUsuario(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReg:
                Usuario u = new Usuario();
                u.setUsuario(us.getText().toString());
                u.setContraseña(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ap.getText().toString());
                if(!u.isNull()) {
                    Toast.makeText(this, "Error: campos vacios!", Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u)) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(Registrar.this, MainActivity.class);
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnCan:
                Intent i = new Intent(Registrar.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }

    }
}