package com.labo1.citas.servicio;

import com.labo1.citas.Modelo.DTO.PacienteDTO;
import com.labo1.citas.Modelo.Entity.Paciente;

import java.util.ArrayList;
import java.util.List;
public class ServicioPaciente {

    private List<Paciente> pacientes = new ArrayList<>(); // Lista de pacientes
    private int contadorPacientes = 1; // Contador para generar IDs únicos

    // Método para obtener la lista completa de pacientes
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public PacienteDTO obtenerPacienteDTO(Paciente paciente) {
        return new PacienteDTO(paciente.getNombre(), paciente.getApellido(), paciente.getDUI());
    }

    public void agregarPaciente(Paciente paciente) {

        String duiDefault = "00000000-0";

        // Validar si ya existe un paciente con el mismo DUI
        for (Paciente p : pacientes) {
            if (!duiDefault.equals(p.getDUI()) &&  p.getDUI().equals(paciente.getDUI()) ) {
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
        // Usamos PacienteDTO para pasar los datos
        pacientes.forEach(paciente -> {
            PacienteDTO pacienteDTO = obtenerPacienteDTO(paciente);
            System.out.println(pacienteDTO.getNombre() + " " + pacienteDTO.getApellido());
        });
    }
}
