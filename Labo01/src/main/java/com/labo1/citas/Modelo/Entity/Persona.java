package com.labo1.citas.Modelo.Entity;

import java.time.LocalDateTime;

// Esta es una clase abstracta que representa a una persona, lo declaro abstract porque en el codigo solo estaremos
// usando las clases Doctor y Paciente, no la clase Persona, por lo que no tiene sentido crear instancias de esta clase
//asi por asi

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String dui;
    private LocalDateTime fechaNacimiento;

    // Constructor de la clase Persona
    public Persona(String nombre, String apellido, String dui, LocalDateTime fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
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
        return dui;
    }

    public void setDUI(String DUI) {
        this.dui = DUI;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
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
                ", dui='" + dui + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}

