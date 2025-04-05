package com.labo1.citas.Modelo.DTO;

public class DoctorDTO {
    private String nombre;
    private String especialidad;

    public DoctorDTO(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
}
