package com.labo1.citas.Modelo.Entity;

import java.time.LocalDateTime;

public class Cita {
    //Protected significa que puede ser accedido solo
    // desde el mismo paquete
    private Doctor doctor;
    private Paciente paciente;
    private String especialidad;
    private LocalDateTime horaFecha;
    private boolean atendido;
    private boolean pacienteLlego;

    // Constructor de la clase Cita
    public Cita(Doctor doctor, Paciente paciente, String especialidad, LocalDateTime horaFecha, boolean atendido, boolean pacienteLlego) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.especialidad = especialidad;
        this.horaFecha = horaFecha;
        this.atendido = atendido;
        this.pacienteLlego = pacienteLlego;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDateTime getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(LocalDateTime horaFecha) {
        this.horaFecha = horaFecha;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public boolean isPacienteLlego() {
        return pacienteLlego;
    }

    public void setPacienteLlego(boolean pacienteLlego) {
        this.pacienteLlego = pacienteLlego;
    }

    // Método toString para representar la clase Cita como una cadena
    // Este método es útil para imprimir la información de la cita
    // en un formato legible
    @Override
    public String toString() {
        return "Cita{" +
                "doctor=" + doctor +
                ", paciente=" + paciente +
                ", especialidad='" + especialidad + '\'' +
                ", horaFecha=" + horaFecha +
                ", atendido=" + atendido +
                ", pacienteLlego=" + pacienteLlego +
                '}';
    }

}