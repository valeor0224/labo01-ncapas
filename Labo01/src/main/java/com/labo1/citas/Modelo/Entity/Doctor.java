package com.labo1.citas.Modelo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Doctor extends Persona {
    private LocalDate fechaReclutacion;
    private String especialidad;
    private String codigoDoctor;

    public Doctor(String nombre, String apellido, String DUI, LocalDate fechaNacimiento, LocalDate fechaReclutacion, String especialidad) {
        super(nombre, apellido, DUI, fechaNacimiento);
        this.fechaReclutacion = fechaReclutacion;
        this.especialidad = especialidad;
        this.codigoDoctor = generarCodigo();  // Aseguramos que el código del doctor se genere al crear el doctor
    }

    public String getCodigoDoctor() {
        return codigoDoctor;
    }

    public void setCodigoDoctor(String codigoDoctor) {
        if (codigoDoctor == null || codigoDoctor.isEmpty()) {
            throw new IllegalArgumentException("El código del doctor no puede ser nulo o vacío");
        }
        this.codigoDoctor = codigoDoctor;
    }

    // Método para generar un código de doctor
    public String generarCodigo() {
        return "ZNH-" + generarNum() + getLetraAleatoria() + generarNum() + "-MD-" + generarNum();
    }

    private String generarNum() {
        return String.valueOf(new Random().nextInt(10));
    }

    private String getLetraAleatoria() {
        char letra = (char) ('A' + new Random().nextInt(26));
        return String.valueOf(letra);
    }

    public String getEspecialidad () {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "ID:'" + codigoDoctor + '\'' +
                ", Nombre: " + getNombre() + " " + getApellido() +
                ", DUI: " + getDUI() +
                ", Fecha en que se unió: " + fechaReclutacion +
                ", Especialidad: '" + especialidad + '\'' +
                '}';
    }
}
