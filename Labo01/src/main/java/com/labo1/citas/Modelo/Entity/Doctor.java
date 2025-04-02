package com.labo1.citas.Modelo.Entity;

import java.time.LocalDateTime;

public class Doctor extends Persona {

    //private Persona persona;
    private LocalDateTime fechaReclutacion;
    private String especialidad;
    private String codigo;

    public Doctor(String nombre, String apellido, String dui, LocalDateTime fechaNacimiento, LocalDateTime fechaReclutacion, String especialidad, String codigo) {
        //super esta llamando al constructor de la clase padre, en este caso Persona, asi cuando se construye un paciente, tambien se construya una persona

        super(nombre, apellido, dui, fechaNacimiento);
        this.fechaReclutacion = fechaReclutacion;
        this.especialidad = especialidad;
        this.codigo = codigo;
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
        return codigo;
    }

    public void setCodigoDoctor(String codigoDoctor) {
        this.codigo = codigoDoctor;
    }
}