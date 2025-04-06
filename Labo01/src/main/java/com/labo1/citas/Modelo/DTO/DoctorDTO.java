package com.labo1.citas.Modelo.DTO;

public class DoctorDTO {
    private String codigoDoctor;
    private String nombre;
    private String especialidad;

    public DoctorDTO(String codigoDoctor, String nombre, String especialidad) {
        this.codigoDoctor = codigoDoctor;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters
    public String getCodigoDoctor() { return codigoDoctor; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }

    // Sobrescribir toString para mejorar la salida de la lista
    @Override
    public String toString() {
        return "Código Doctor: " + codigoDoctor + " - " + nombre + " (" + especialidad + ")";
    }
}
