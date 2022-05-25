package com.cdp.malaga_ocio;

import java.io.Serializable;

public class LugaresVO implements Serializable {
    private String Nombre;
    private String edad;
    private String precio;
    private String ubicacion;
    private String descripcion;
    private int imagen;
    private double latitud;
    private double longitud;



    public LugaresVO() {

    }

    public LugaresVO(String nombre, String edad, String precio, String ubicacion, String descripcion, int imagen, double latitud ,double longitud) {
        this.Nombre = nombre;
        this.edad = edad;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.longitud = longitud;
        this.latitud = latitud;

    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
