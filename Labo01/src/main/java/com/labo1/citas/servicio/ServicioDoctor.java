package com.labo1.citas.servicio;

import com.labo1.citas.Modelo.Entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class ServicioDoctor {
    private List<Doctor> doctores;

    public ServicioDoctor() {
        this.doctores = new ArrayList<>();
    }

    // Agregar un nuevo doctor
    public void agregarDoctor(Doctor doctor) {
        // Validar si ya existe un doctor con el mismo código
        for (Doctor d : doctores) {
            if (d.getCodigoDoctor().equals(doctor.getCodigoDoctor())) {
                System.out.println("Error: Ya existe un doctor con ese código.");
                return;
            }
        }
        doctores.add(doctor);
        System.out.println("Doctor registrado con éxito: " + doctor.getNombre() + " " + doctor.getApellido());
    }

    // Buscar un doctor por su código
    public Doctor buscarDoctorPorCodigo(String codigo) {
        for (Doctor doctor : doctores) {
            if (doctor.getCodigoDoctor().equals(codigo)) {
                return doctor;
            }
        }
        System.out.println("Error: No se encontró un doctor con ese código.");
        return null;
    }

    // Listar todos los doctores registrados
    public List<Doctor> listarDoctores() {
        return doctores;
    }
}