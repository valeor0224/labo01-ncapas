package com.labo1.citas.servicio;

import modelo.Cita;
import modelo.Doctor;
import modelo.Paciente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioCita {
    private List<Cita> citas;

    public ServicioCita() {
        citas = new ArrayList<>();
    }

    // Método para agendar una nueva cita
    public boolean agendarCita(Doctor doctor, Paciente paciente, String especialidad, LocalDateTime horaFecha) {
        // Validar que la hora esté entre las 8 AM y las 4 PM
        if (horaFecha.getHour() < 8 || horaFecha.getHour() >= 16) {
            System.out.println("Error: La hora de la cita debe estar entre las 8:00 AM y las 4:00 PM.");
            return false;
        }

        // Validar que no haya dos citas a la misma hora con el mismo doctor
        for (Cita cita : citas) {
            if (cita.getDoctor().equals(doctor) && cita.getHoraFecha().equals(horaFecha)) {
                System.out.println("Error: El doctor ya tiene una cita a esta hora.");
                return false;
            }
            if (cita.getPaciente().equals(paciente) && cita.getHoraFecha().equals(horaFecha)) {
                System.out.println("Error: El paciente ya tiene una cita a esta hora.");
                return false;
            }
        }

        // Si todo está bien, se agenda la cita
        Cita nuevaCita = new Cita(doctor, paciente, especialidad, horaFecha);
        citas.add(nuevaCita);
        System.out.println("Cita agendada con éxito: " + nuevaCita);
        return true;
    }

    // Método para listar todas las citas agendadas
    public List<Cita> listarCitas() {
        return citas;
    }

    // Método para listar las citas del día
    public List<Cita> listarCitasDelDia() {
        List<Cita> citasDelDia = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for (Cita cita : citas) {
            if (cita.getHoraFecha().toLocalDate().equals(now.toLocalDate())) {
                citasDelDia.add(cita);
            }
        }
        return citasDelDia;
    }

    // Método para listar citas por doctor
    public List<Cita> listarCitasPorDoctor(Doctor doctor) {
        List<Cita> citasDoctor = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getDoctor().equals(doctor)) {
                citasDoctor.add(cita);
            }
        }
        return citasDoctor;
    }

    // Método para cancelar una cita (cuando el paciente no llega)
    public boolean cancelarCita(Cita cita) {
        if (citas.remove(cita)) {
            System.out.println("Cita cancelada: " + cita);
            return true;
        } else {
            System.out.println("Error: La cita no fue encontrada.");
            return false;
        }
    }
}
