package com.labo1.citas.servicio;

import com.labo1.citas.Modelo.Entity.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ServicioPaciente {
    private List<Paciente> pacientes;

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

}
