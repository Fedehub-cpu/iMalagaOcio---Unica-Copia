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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user, pass;
    Button btnEntrar, btnRegistrar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText) findViewById(R.id.user);
        pass=(EditText) findViewById(R.id.pass);
        btnEntrar=(Button) findViewById(R.id.btnEntrar);
        btnRegistrar=(Button) findViewById(R.id.btnRegistrar);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao= new daoUsuario(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEntrar:
                String u = user.getText().toString();
                String p = pass.getText().toString();
                if(u.equals("")&&p.equals("")) {
                    Toast.makeText(this, "Error!: Campos vacios", Toast.LENGTH_SHORT).show();
                }else if(dao.login(u,p)==1) {
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos!", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(MainActivity.this, Menu.class);
                    Bundle b = new Bundle();
                    String name= user.getText().toString();
                    b.putString("username", name);
                    i2.putExtras(b);
                    startActivity(i2);

                }else{
                    Toast.makeText(this, "Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRegistrar:
                Intent i = new Intent(MainActivity.this, Registrar.class);
                startActivity(i);
                break;
        }
    }


}