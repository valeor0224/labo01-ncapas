package com.citas.Modelo.Entity;

public class Paciente {

    private Persona persona;

    public Paciente(String nombre, String apellido, String DUI, String fechaNacimiento) {
        this.persona = new Persona(nombre, apellido, DUI, fechaNacimiento);
    }
}