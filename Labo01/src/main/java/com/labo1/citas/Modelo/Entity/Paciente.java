package com.labo1.citas.Modelo.Entity;

import java.time.LocalDateTime;

public class Paciente extends Persona {

    //private Persona persona;

    public Paciente(String nombre, String apellido, String DUI, LocalDateTime fechaNacimiento) {
        super(nombre, apellido, DUI, fechaNacimiento);
    }
}