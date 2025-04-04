package com.labo1.citas.Presentacion;

import com.labo1.citas.servicio.ServicioDoctor;
import com.labo1.citas.servicio.ServicioPaciente;
import com.labo1.citas.servicio.ServicioCita;
import com.labo1.citas.modelo.Doctor;
import com.labo1.citas.modelo.Paciente;
import com.labo1.citas.modelo.Cita;

import java.util.Scanner;

public class Menu {
    private ServicioDoctor servicioDoctor;
    private ServicioPaciente servicioPaciente;
    private ServicioCita servicioCita;
    private Scanner scanner;

    public Menu(ServicioDoctor servicioDoctor, ServicioPaciente servicioPaciente, ServicioCita servicioCita) {
        this.servicioDoctor = servicioDoctor;
        this.servicioPaciente = servicioPaciente;
        this.servicioCita = servicioCita;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer
            manejarOpcion(opcion);
        }
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Registrar Doctor");
        System.out.println("2. Registrar Paciente");
        System.out.println("3. Agendar Cita");
        System.out.println("4. Ver todas las Citas");
        System.out.println("5. Ver Citas por Doctor");
        System.out.println("6. Cancelar Cita");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarDoctor();
                break;
            case 2:
                registrarPaciente();
                break;
            case 3:
                agendarCita();
                break;
            case 4:
                verCitas();
                break;
            case 5:
                verCitasPorDoctor();
                break;
            case 6:
                cancelarCita();
                break;
            case 7:
                System.out.println("¡Hasta luego!");
                System.exit(0);
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void registrarDoctor() {
        System.out.print("Nombre del Doctor: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del Doctor: ");
        String apellido = scanner.nextLine();
        System.out.print("Código del Doctor (Formato ZNH-XXX-MD-AX): ");
        String codigo = scanner.nextLine();
        System.out.print("Especialidad del Doctor: ");
        String especialidad = scanner.nextLine();

        // Delegar la lógica al servicio correspondiente
        Doctor doctor = new Doctor(nombre, apellido, "DUI12345678", null, codigo, especialidad);
        servicioDoctor.agregarDoctor(doctor);
    }

    private void registrarPaciente() {
        System.out.print("Nombre del Paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del Paciente: ");
        String apellido = scanner.nextLine();
        System.out.print("DUI del Paciente: ");
        String dui = scanner.nextLine();

        // Delegar la lógica al servicio correspondiente
        Paciente paciente = new Paciente(nombre, apellido, dui, null);
        servicioPaciente.agregarPaciente(paciente);
    }

    private void agendarCita() {
        System.out.print("Código del Doctor: ");
        String codigoDoctor = scanner.nextLine();
        Doctor doctor = servicioDoctor.buscarDoctorPorCodigo(codigoDoctor);
        if (doctor == null) {
            System.out.println("Doctor no encontrado.");
            return;
        }

        System.out.print("DUI del Paciente: ");
        String duiPaciente = scanner.nextLine();
        Paciente paciente = servicioPaciente.buscarPacientePorDUI(duiPaciente);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Fecha y hora de la cita (Formato: yyyy-MM-ddTHH:mm): ");
        String fechaHora = scanner.nextLine();
        Cita cita = new Cita(doctor, paciente, especialidad, LocalDateTime.parse(fechaHora));

        // Delegar la lógica al servicio de citas
        servicioCita.agendarCita(cita);
    }

    private void verCitas() {
        for (Cita cita : servicioCita.listarCitas()) {
            System.out.println(cita);
        }
    }

    private void verCitasPorDoctor() {
        System.out.print("Código del Doctor: ");
        String codigo = scanner.nextLine();
        Doctor doctor = servicioDoctor.buscarDoctorPorCodigo(codigo);
        if (doctor != null) {
            for (Cita cita : servicioCita.listarCitasPorDoctor(doctor)) {
                System.out.println(cita);
            }
        } else {
            System.out.println("Doctor no encontrado.");
        }
    }

    private void cancelarCita() {
        // Implementación similar a las demás
        System.out.println("Cancelar Cita (funcionalidad pendiente de implementación)");
    }
}
