package com.labo1.citas.servicio;

import com.labo1.citas.Modelo.DTO.DoctorDTO;
import com.labo1.citas.Modelo.DTO.PacienteDTO;
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
        // Usamos DTOs aquí, y no las entidades completas.
        PacienteDTO patientDTO = findPatient(patientId);
        DoctorDTO doctorDTO = findDoctor(doctorId);

        if (patientDTO == null || doctorDTO == null) {
            System.out.println("❌ No se encontró el paciente o doctor.");
            return;
        }

        // Transformar el DTO a una entidad para usarla en la Cita
        Paciente patient = new Paciente(patientDTO.getNombre(), patientDTO.getApellido(), patientDTO.getDui(), LocalDate.now());
        Doctor doctor = new Doctor(doctorDTO.getNombre(), doctorDTO.getEspecialidad(), "codigo123", LocalDate.now(), LocalDate.now(), doctorDTO.getEspecialidad());

        String especialidadCita = doctor.getEspecialidad();

        for (Cita cita : citas) {
            if (cita.getCitaHora().equals(horaCita) && cita.getCitaFecha().equals(fechaCita) &&
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
        if (citas.isEmpty()) {
            System.out.println("No se encontraron citas.");
            return;
        }
        citas.forEach(System.out::println);
    }

    public PacienteDTO findPatient(String id) {
        return servPacientes.getPacientes().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(paciente -> servPacientes.obtenerPacienteDTO(paciente)) // Mapear a DTO
                .orElse(null);
    }


    public DoctorDTO findDoctor(String id) {
        // Obtener un Doctor de la lista usando el metodo getDoctores()
        Doctor doctor = servDoctores.getDoctores().stream()
                .filter(d -> d.getCodigoDoctor().equals(id))
                .findFirst()
                .orElse(null);

        if (doctor != null) {
            // Convertir la entidad Doctor a DoctorDTO
            return servDoctores.obtenerDoctorDTO(doctor);
        } else {
            return null;
        }
    }

    public void DeleteCita(String codigo) {
        citas.removeIf(c -> c.getId().equals(codigo));
    }

    public void findCitaDoctor(String id) {
        for (Cita cita : citas) {
            if (cita.getDoctor() != null && cita.getDoctor().getCodigoDoctor() != null) {
                if (cita.getDoctor().getCodigoDoctor().equals(id)) {
                    System.out.println(cita);
                }
            } else {
                System.out.println("❌ El doctor no tiene un código asignado.");
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
