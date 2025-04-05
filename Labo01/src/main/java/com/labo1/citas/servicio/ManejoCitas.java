package com.labo1.citas.servicio;

import com.labo1.citas.Modelo.Entity.Cita;
import com.labo1.citas.Modelo.Entity.Doctor;
import com.labo1.citas.Modelo.Entity.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ManejoCitas {
    private List<Cita> citas = new ArrayList<>();

    private ServicioDoctor servDoctores;

    private ServicioPaciente servPacientes;

    public ManejoCitas(ServicioDoctor servDoctores, ServicioPaciente servPacientes) {
        this.servDoctores = servDoctores;
        this.servPacientes = servPacientes;
    }



    private int contadorCitas = 1;


    public void agendarCita(String patientId, String doctorId, LocalDate fechaCita, LocalTime horaCita) {
        Paciente patient = findPatient(patientId);
        Doctor doctor = findDoctor(doctorId);

        if (patient == null || doctor == null) {
            System.out.println("❌ No se encontró el paciente o doctor.");
            return;
        }

        String especialidadCita = doctor.getEspecialidad();


        for (Cita cita : citas) {
            if(cita.getCitaHora().equals(horaCita)&&cita.getCitaFecha().equals(fechaCita)&&
                    (cita.getDoctor().getCodigoDoctor().equals(doctorId) || cita.getPaciente().getId().equals(patientId))) {
                System.out.println("No es posible agendar cita.");
                return;
            }
        }



        Cita nuevaCita = new Cita(doctor, patient, especialidadCita, fechaCita, horaCita);

        String idGenerado = "C" + contadorCitas++;


        nuevaCita.setId(idGenerado);


        citas.add(nuevaCita);



        System.out.println("📅 Cita agendada para " + patient.getNombre() + " con Dr. " + doctor.getNombre());
    }

    public void listCitas() {
        System.out.println("Lista de Citas:");
        citas.forEach(System.out::println);
    }

    public Paciente findPatient(String id) {
        return servPacientes.getPacientes().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Doctor findDoctor(String id) {


        return servDoctores.getDoctores().stream()
                .filter(d -> d.getCodigoDoctor().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void DeleteCita(LocalDate fecha, LocalTime hora) {
        /*for (Cita c : citas) {
            if (c.getCitaFecha().equals(fecha) && c.getCitaHora().equals(hora)) {
                citas.remove(c);
            }
        }*/
        citas.removeIf(c -> c.getCitaFecha().equals(fecha) && c.getCitaHora().equals(hora));

    }

    public void findCitaDoctor(String id) {
        for(Cita cita : citas) {
            if(cita.getDoctor().getCodigoDoctor().equals(id)) {
                System.out.println(cita);
            }
        }
    }

    public void findCitaFecha(LocalDate fecha) {
        for(Cita cita : citas) {
            if(cita.getCitaFecha().equals(fecha)) {
                System.out.println(cita);
            }
            else {
                System.out.println("No se encontraron citas para esa fecha.");
            }
        }
    }

    public void marcarAsistencia (String codigoCita) {

        for (Cita cita : citas) {
            if(cita.getId().equals(codigoCita)) {
                cita.setAsistenciaPaciente(true);
                System.out.println("Asistencia marcada con éxito.");
            }
            else {
                System.out.println("No se encontró cita");
            }

        }

    }



}
