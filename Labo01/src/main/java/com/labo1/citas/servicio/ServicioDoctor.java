package com.labo1.citas.servicio;

import com.labo1.citas.Modelo.Entity.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServicioDoctor {

    private List<Doctor> doctores = new ArrayList<>();

    public List<Doctor> getDoctores() {
        return doctores;
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
        System.out.println("Lista de Doctores:");
        doctores.forEach(System.out::println);
    }

}