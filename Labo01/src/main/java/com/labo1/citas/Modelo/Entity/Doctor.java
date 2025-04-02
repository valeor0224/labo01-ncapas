package com.labo1.citas.Modelo.Entity;

import java.time.LocalDateTime;

public class Doctor extends Persona {

    //private Persona persona;
    private LocalDateTime fechaReclutacion;
    private String especialidad;
    private String codigoDoctor;

    public Doctor(String nombre, String apellido, String DUI, LocalDateTime fechaNacimiento, LocalDateTime fechaReclutacion, String especialidad, String codigoDoctor) {
        super(nombre, apellido, DUI, fechaNacimiento);
        this.fechaReclutacion = fechaReclutacion;
        this.especialidad = especialidad;
        this.codigoDoctor = codigoDoctor;
    }

    public LocalDateTime getFechaReclutacion() {
        return fechaReclutacion;
    }

    public void setFechaReclutacion(LocalDateTime fechaReclutacion) {
        this.fechaReclutacion = fechaReclutacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodigoDoctor() {
        return codigoDoctor;
    }

    public void setCodigoDoctor(String codigoDoctor) {
        this.codigoDoctor = codigoDoctor;
    }
}