package com.cdp.malaga_ocio.entidades;

public class Usuario {
    int id;
    String Nombre, Apellidos, Usuario, Contraseña;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellidos, String usuario, String contraseña) {
        this.id = id;
        Nombre = nombre;
        Apellidos = apellidos;
        Usuario = usuario;
        Contraseña = contraseña;
    }

    public boolean isNull() {
        if(Nombre.equals("")&&Apellidos.equals("")&&Usuario.equals("")&&Contraseña.equals("")) {
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

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                '}';
    }
}


