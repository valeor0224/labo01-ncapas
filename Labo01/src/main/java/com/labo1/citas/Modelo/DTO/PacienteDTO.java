package com.labo1.citas.Modelo.DTO;

public class PacienteDTO {
    private String nombre;
    private String apellido;
    private String dui;

    public PacienteDTO(String nombre, String apellido, String dui) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDui() { return dui; }
}
