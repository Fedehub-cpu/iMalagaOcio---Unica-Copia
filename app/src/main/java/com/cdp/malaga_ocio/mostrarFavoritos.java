package com.cdp.malaga_ocio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.cdp.malaga_ocio.entidades.ConexionSQLITE;
import com.cdp.malaga_ocio.entidades.Favorito;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class mostrarFavoritos extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Favorito> listaLugares;
    private Button btnBorrar;
    private RecyclerView recyclerV2;
    Adaptador_Favoritos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_favs);

        listaLugares= new ArrayList<>();
        recyclerV2 = (RecyclerView) findViewById(R.id.recyclerId2);
        recyclerV2.setLayoutManager(new LinearLayoutManager(this));
        btnBorrar = (Button) findViewById(R.id.itBorrar);
        btnBorrar.setOnClickListener(this);

        registerForContextMenu(recyclerV2);

        llenarFavoritos();

         adapter = new Adaptador_Favoritos(listaLugares, new Adaptador_Favoritos.OnItemClickListener() {
            @Override
            public void onItemClick(Favorito favorito) {

            }
        });

        recyclerV2.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_favoritos, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itBorrar:


    AlertDialog dialogo = new AlertDialog.Builder(this)
            .setTitle("Mensaje de advertencia")
            .setMessage("¿Esta seguro de eliminar este elemento?")
            .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    eliminarItem();
                    adapter.RemoveItem(item.getGroupId());
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }).create();
    dialogo.show();



            case R.id.itUbic:
                Toast.makeText(this, "Ver Ubicación", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @SuppressLint("ResourceType")
    public void llenarFavoritos() {

        String bd2 = "BDFavoritos";
        Favorito f;
        String tabla = "create table if not exists favorito(id integer primary key autoincrement, nombre text, ubicacion text)";
        SQLiteDatabase sql;


        sql = this.openOrCreateDatabase(bd2, this.MODE_PRIVATE, null);
        sql.execSQL(tabla);

        Cursor cursor = sql.rawQuery(" SELECT * FROM Favorito", null);
        while(cursor.moveToNext()){
            Favorito favorito = null;
            favorito = new Favorito();
            favorito.setId(cursor.getInt(0));
            favorito.setNombre(cursor.getString(1));
            favorito.setUbicacion(cursor.getString(2));
            listaLugares.add(favorito);
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.itBorrar:
                Intent i = new Intent(mostrarFavoritos.this, agregarFavorito.class);
                startActivity(i);
                break;
    }
}


public void eliminarItem() {


    ConexionSQLITE con = new ConexionSQLITE (getApplicationContext(), "BDFavoritos", null, 1);
    SQLiteDatabase db = con.getWritableDatabase();
    Favorito f;

    String sql = "DELETE FROM Favorito WHERE id IN (SELECT id FROM favorito ORDER BY id ASC LIMIT 1)";
    db.execSQL(sql);


    };

}


