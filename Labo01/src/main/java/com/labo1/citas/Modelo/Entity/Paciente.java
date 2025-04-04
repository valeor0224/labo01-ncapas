package com.labo1.citas.Modelo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente extends Persona {

    //private Persona persona;
    public String id;

    public Paciente(String nombre, String apellido, String DUI, LocalDate fechaNacimiento) {
        super(nombre, apellido, DUI, fechaNacimiento);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", dui='" + getDUI() + '\'' +
                ", fechaNacimiento=" + getFechaNacimiento() +
                '}';
    }
}