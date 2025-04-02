package com.citas.Modelo.Entity;

public class Persona {
    private String nombre;
    private String apellido;
    private String DUI;
    private String fechaNacimiento;

    public Persona(String nombre, String apellido, String DUI, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DUI = DUI;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}