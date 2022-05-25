package com.cdp.malaga_ocio.entidades;

public class Favorito {

    int id;
    String Nombre, Ubicacion;

    public Favorito() {

    }

    public Favorito(int id, String nombre, String ubicacion) {
        this.id = id;
        Nombre = nombre;
        Ubicacion = ubicacion;
    }

    public boolean isNull() {
        if(Nombre.equals("")&&Ubicacion.equals("")) {
            return false;
        }else{
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Favorito{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Ubicacion='" + Ubicacion + '\'' +
                '}';
    }
}
