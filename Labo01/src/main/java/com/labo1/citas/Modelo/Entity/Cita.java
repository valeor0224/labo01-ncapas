package com.labo1.citas.Modelo.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    //Protected significa que puede ser accedido solo
    // desde el mismo paquete
    private Doctor doctor;
    private Paciente paciente;
    private String especialidad;
    private LocalDate citaFecha;
    private LocalTime citaHora;

    public Cita(Doctor doctor, Paciente paciente, String especialidad, LocalDate citaFecha, LocalTime citaHora) {
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.paciente = paciente;
        this.citaFecha = citaFecha;
        this.citaHora = citaHora;
    }


// Getters y Setters

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getCitaFecha() {
        return citaFecha;
    }

    public void setCitaFecha(LocalDate citaFecha) {
        this.citaFecha = citaFecha;
    }

    public LocalTime getCitaHora() {
        return citaHora;
    }

    public void setCitaHora(LocalTime citaHora) {
        this.citaHora = citaHora;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "doctor=" + doctor +
                ", paciente=" + paciente +
                ", especialidad='" + especialidad + '\'' +
                ", citaFecha=" + citaFecha +
                ", citaHora=" + citaHora +
                '}';
    }
}