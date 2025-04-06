package com.labo1.citas.servicio;

import com.labo1.citas.Modelo.DTO.DoctorDTO;
import com.labo1.citas.Modelo.Entity.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServicioDoctor {

    private List<Doctor> doctores = new ArrayList<>();

    // Método para obtener la lista de doctores
    public List<Doctor> getDoctores() {
        return doctores; // Devuelve la lista completa de doctores
    }

    // Método para convertir Doctor a DoctorDTO
    public DoctorDTO obtenerDoctorDTO(Doctor doctor) {
        // Ahora creamos el DTO con el código del doctor, nombre y especialidad
        return new DoctorDTO(doctor.getCodigoDoctor(), doctor.getNombre(), doctor.getEspecialidad());
    }


    private Random random = new Random();


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
        if (doctores.isEmpty()) {
            System.out.println("No se encontraron doctores.");
        } else {
            doctores.forEach(doctor -> {
                DoctorDTO doctorDTO = obtenerDoctorDTO(doctor);  // Se obtiene el DTO con el código del doctor
                System.out.println(doctorDTO);  // Esto invoca automáticamente el toString() del DTO
            });
        }
    }

}