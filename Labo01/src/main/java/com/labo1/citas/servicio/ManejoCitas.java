package com.labo1.citas.servicio;

import com.labo1.citas.Modelo.Entity.Cita;
import com.labo1.citas.Modelo.Entity.Doctor;
import com.labo1.citas.Modelo.Entity.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManejoCitas {
    private List<Paciente> pacientes = new ArrayList<>(); // Lista de pacientes
    private List<Doctor> doctores = new ArrayList<>();
    private List<Cita> citas = new ArrayList<>();
    private Random random = new Random();

    private int contadorPacientes = 1; // Contador para generar IDs únicos

    public void agregarPaciente(Paciente paciente) {

        // Validar si ya existe un paciente con el mismo DUI
        for (Paciente p : pacientes) {
            if (p.getDUI().equals(paciente.getDUI())) {
                System.out.println("❌ Error: Ya existe un paciente con el mismo DUI.");
                return;
            }
        }

        // Generar ID automático
        String idGenerado = "P" + contadorPacientes++;
        paciente.setId(idGenerado); // Asignar el ID al paciente

        // Agregar paciente a la lista
        pacientes.add(paciente);
        System.out.println("✅ Paciente registrado con éxito: " + paciente.getNombre() + " " + paciente.getApellido() + " (ID: " + idGenerado + ")");
    }

    public void listPatients() {
        System.out.println("👥 Lista de Pacientes:");
        pacientes.forEach(System.out::println);
    }

    public void agregarDoctor(Doctor doctor) {




        String codigo = generarCodigo();
        System.out.println("Código generado: " + codigo);

        for (Doctor doc : doctores) {
            while (doc.getCodigoDoctor().equals(codigo)) {
                codigo = generarCodigo();
                System.out.println("Código generado: " + codigo);
            }
        }

        doctor.setCodigoDoctor(codigo);



       doctores.add(doctor);
    }

    public String generarCodigo() {
        return "ZNH-" + generarNum() + getLetraAleatoria() + generarNum() + "-MD-" + generarNum() + getLetraAleatoria() ;
    }

    private String generarNum() {
        return String.valueOf(random.nextInt(10));
    }

    private String getLetraAleatoria() {
        char letra = (char) ('A' + random.nextInt(26));
        return String.valueOf(letra); // Genera una letra mayúscula aleatoria
    }

    public void listDoctors() {
        System.out.println("Lista de Doctores:");
        doctores.forEach(System.out::println);
    }

    public void agendarCita(String patientId, String doctorId, LocalDate fechaCita, LocalTime horaCita) {
        Paciente patient = findPatient(patientId);
        Doctor doctor = findDoctor(doctorId);

        if (patient == null || doctor == null) {
            System.out.println("❌ No se encontró el paciente o doctor.");
            return;
        }

        String especialidadCita = doctor.getEspecialidad();


        for (Cita cita : citas) {
            if(cita.getCitaHora().equals(horaCita)&& (cita.getCitaFecha().equals(fechaCita) || cita.getPaciente().getId().equals(patient.getId()))) {
                System.out.println("No es posible agendar cita.");
                return;
            }
        }

        Cita nuevaCita = new Cita(doctor, patient, especialidadCita, fechaCita, horaCita);
        citas.add(nuevaCita);



        System.out.println("📅 Cita agendada para " + patient.getNombre() + " con Dr. " + doctor.getNombre());
    }

    public void listCitas() {
        System.out.println("Lista de Citas:");
        citas.forEach(System.out::println);
    }

    public Paciente findPatient(String id) {
        return pacientes.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Doctor findDoctor(String id) {
        return doctores.stream()
                .filter(d -> d.getCodigoDoctor().equals(id))
                .findFirst()
                .orElse(null);
    }









}
