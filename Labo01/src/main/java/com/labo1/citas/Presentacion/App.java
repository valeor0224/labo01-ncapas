package com.labo1.citas.Presentacion;

import com.labo1.citas.servicio.ServicioDoctor;
import com.labo1.citas.servicio.ServicioPaciente;
import com.labo1.citas.servicio.ServicioCita;
import com.labo1.citas.modelo.Doctor;
import com.labo1.citas.modelo.Paciente;
import com.labo1.citas.modelo.Cita;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Instanciar los servicios
        ServicioDoctor servicioDoctor = new ServicioDoctor();
        ServicioPaciente servicioPaciente = new ServicioPaciente();
        ServicioCita servicioCita = new ServicioCita();

        // Crear e iniciar el menú
        Menu menu = new Menu(servicioDoctor, servicioPaciente, servicioCita);
        menu.iniciar();
    }
}
