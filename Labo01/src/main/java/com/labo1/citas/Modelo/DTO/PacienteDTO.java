package com.labo1.citas.Modelo.DTO;

public class PacienteDTO {
    private String id;  // Agregado: El ID del paciente
    private String nombre;
    private String apellido;
    private String dui;

    public PacienteDTO(String id, String nombre, String apellido, String dui) {
        this.id = id;  // Inicializar el ID del paciente
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDui() { return dui; }

    // Sobrescribir toString para mejorar la salida de la lista
    @Override
    public String toString() {
        return "ID: " + id + " - " + nombre + " " + apellido + " (DUI: " + dui + ")";
    }
}
