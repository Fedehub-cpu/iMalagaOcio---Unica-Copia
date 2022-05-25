package com.cdp.malaga_ocio.entidades;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoFavorito {

    Context c;
    Favorito f;
    ArrayList<Favorito> lista;
    SQLiteDatabase sql;
    String bd2= "BDFavoritos";
    String tabla= "create table if not exists favorito(id integer primary key autoincrement, nombre text, ubicacion text)";

    public daoFavorito(Context c) {
        this.c=c;
        sql=c.openOrCreateDatabase(bd2, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        f=new Favorito();
    }

    public boolean insertFavorito(Favorito f) {
        if(buscar(f.getNombre())==0){

            ContentValues cv = new ContentValues();
            cv.put("nombre", f.getNombre());
            cv.put("ubicacion", f.getUbicacion());
            return (sql.insert("favorito", null, cv)>0);
        }else{
            return false;
        }
    }

    public int buscar(String f) {
        int x=0;
        lista=selectFavorito();
        for (Favorito fav:lista) {
            if(fav.getNombre().equals(f)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Favorito> selectFavorito(){
        ArrayList<Favorito> lista = new ArrayList<Favorito>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from favorito", null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                Favorito f = new Favorito();
                f.setId(cr.getInt(0));
                f.setNombre(cr.getString(1));
                f.setUbicacion(cr.getString(2));
                lista.add(f);
            }while(cr.moveToNext());
        }
        return lista;
    }

}
