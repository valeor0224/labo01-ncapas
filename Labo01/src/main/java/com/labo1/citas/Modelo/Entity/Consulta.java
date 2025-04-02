package com.labo1.citas.Modelo.Entity;

import java.time.LocalDateTime;

public class Consulta extends Cita {
    //private Cita cita;
    //private solo puede ser accedido desde su propia clase
    private boolean asistenciaPaciente;
    private String motivoConsulta;

    public Consulta(Doctor doctor, Paciente paciente, LocalDateTime horaFecha, boolean asistenciaPaciente, String motivoConsulta) {
        super(doctor, paciente, horaFecha);
        this.asistenciaPaciente = asistenciaPaciente;
        this.motivoConsulta = motivoConsulta;
    }

    public boolean isAsistenciaPaciente() {
        return asistenciaPaciente;
    }

    public void setAsistenciaPaciente(boolean asistenciaPaciente) {
        this.asistenciaPaciente = asistenciaPaciente;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
}
