package com.labo1.citas.Modelo.Entity;

import java.time.LocalDateTime;

public class Persona {
    private String nombre;
    private String apellido;
    private String DUI;
    private LocalDateTime fechaNacimiento;

    public Persona(String nombre, String apellido, String DUI, LocalDateTime fechaNacimiento) {
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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}