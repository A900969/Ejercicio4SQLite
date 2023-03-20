package com.example.ejecicio4sqlite;

import java.io.Serializable;

public class Persona implements Serializable {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private String direccion;

    public Persona(String dni, String nombre, String apellidos, int edad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
