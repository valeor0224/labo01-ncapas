package com.labo1.citas.Modelo.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta extends Cita {
    //private Cita cita;
    //private solo puede ser accedido desde su propia clase
    private String motivoConsulta;

    public Consulta(Doctor doctor, Paciente paciente, String especialidad, LocalDate citaFecha, LocalTime citaHora, boolean asistenciaPaciente, String motivoConsulta) {
        super(doctor, paciente, especialidad, citaFecha, citaHora);
        this.motivoConsulta = motivoConsulta;
    }


    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
}
