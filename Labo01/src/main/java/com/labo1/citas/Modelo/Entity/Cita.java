package com.labo1.citas.Modelo.Entity;

import java.time.LocalDateTime;

public class Cita {
    protected Paciente paciente;
    protected Doctor doctor;
    protected LocalDateTime horaFecha;


    public Cita(Doctor doctor, Paciente paciente, LocalDateTime horaFecha) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.horaFecha = horaFecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getHoraFecha() {
        return horaFecha;
    }
}