package com.labo1.citas.Modelo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Doctor extends Persona {

    //private Persona persona;
    private LocalDate fechaReclutacion;
    private String especialidad;
    private String codigoDoctor;

    public Doctor(String nombre, String apellido, String DUI, LocalDate fechaNacimiento, LocalDate fechaReclutacion, String especialidad) {
        //super esta llamando al constructor de la clase padre, en este caso Persona, asi cuando se construye un paciente, tambien se construya una persona

        super(nombre, apellido, DUI, fechaNacimiento);
        this.fechaReclutacion = fechaReclutacion;
        this.especialidad = especialidad;
    }

    public LocalDate getFechaReclutacion() {
        return fechaReclutacion;
    }

    public void setFechaReclutacion(LocalDate fechaReclutacion) {
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


    @Override
    public String toString() {
        return "Doctor{" +
                "codigoDoctor='" + codigoDoctor + '\'' +
                ",nombre" + getNombre() +
                ", apellido" + getApellido() +
                ", DUI" + getDUI() +
                "fechaReclutacion=" + fechaReclutacion +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}