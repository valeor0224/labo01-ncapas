package com.labo1.citas.Modelo.Entity;

import java.time.LocalDate;

// Esta es una clase abstracta que representa a una persona, lo declaro abstract porque en el codigo solo estaremos
// usando las clases Doctor y Paciente, no la clase Persona, por lo que no tiene sentido crear instancias de esta clase
//asi por asi

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String DUI;
    private LocalDate fechaNacimiento;

    // Constructor de la clase Persona
    public Persona(String nombre, String apellido, String DUI, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DUI = DUI;
        this.fechaNacimiento = fechaNacimiento;
    }


    // Getters y Setters
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Método toString para representar la clase Persona como una cadena
    // Este método es útil para imprimir la información de la persona
    // en un formato legible
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dui='" + DUI + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}

