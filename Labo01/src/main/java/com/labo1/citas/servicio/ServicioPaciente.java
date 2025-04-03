package com.labo1.citas.servicio

import modelo.Paciente;
import java.util.ArrayList;
import java.util.List;

public class ServicioPaciente {
    private List<Paciente> pacientes;

    public ServicioPaciente() {
        this.pacientes = new ArrayList<>();
    }

    // Agregar un nuevo paciente
    public void agregarPaciente(Paciente paciente) {
        // Validar si ya existe un paciente con el mismo DUI
        for (Paciente p : pacientes) {
            if (p.getDui().equals(paciente.getDui())) {
                System.out.println("Error: Ya existe un paciente con el mismo DUI.");
                return;
            }
        }
        pacientes.add(paciente);
        System.out.println("Paciente registrado con éxito: " + paciente.getNombre() + " " + paciente.getApellido());
    }

    // Buscar un paciente por su DUI
    public Paciente buscarPacientePorDUI(String dui) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDui().equals(dui)) {
                return paciente;
            }
        }
        System.out.println("Error: No se encontró un paciente con ese DUI.");
        return null;
    }

    // Listar todos los pacientes registrados
    public List<Paciente> listarPacientes() {
        return pacientes;
    }
}
