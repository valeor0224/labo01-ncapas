package com.labo1.citas.Presentacion;

import com.labo1.citas.Modelo.Entity.Doctor;
import com.labo1.citas.Modelo.Entity.Paciente;
import com.labo1.citas.servicio.ManejoCitas;
import com.labo1.citas.servicio.ServicioDoctor;
import com.labo1.citas.servicio.ServicioPaciente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private ManejoCitas manager; // ✅ Declare instance variable
    private ServicioDoctor managerDoctor;
    private ServicioPaciente managerPaciente;
    private Scanner scanner;

    // ✅ Constructor initializes `PacienteService` and `Scanner`
    public Menu() {
        this.managerDoctor = new ServicioDoctor();
        this.managerPaciente = new ServicioPaciente();
        this.manager = new ManejoCitas(managerDoctor, managerPaciente);
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            printBox("MUNDO SALVA VIDAS");
            System.out.println("1. Agregar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Agregar Doctor");
            System.out.println("4. Listar Doctores");
            System.out.println("5. Agregar Cita");
            System.out.println("6. Listar Citas");
            System.out.println("7. Cancelar Cita");
            System.out.println("8. Listar cita por código del doctor");
            System.out.println("9. Marcar asistencia:");
            System.out.println("10. Buscar cita por fecha");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarPacienteDesdeMenu();
                    break;

                case 2:
                    managerPaciente.listPatients();
                    break;

                case 3:
                    agregarDoctordesMenu();
                    break;

                case 4:
                    managerDoctor.listDoctors();
                    break;

                case 5:
                    agregarCitasMenu();
                    break;

                case 6:
                    manager.listCitas();
                    break;

                case 7:
                    EliminarCita();
                    break;

                case 8:
                    findCitasPorDoctorMenu();
                    break;

                case 9:
                    marcarAsistenciaMenu();
                    break;

                case 10:
                    findCitasPorFecha();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Opción no válida.");
            }
        }
    }



    private void agregarPacienteDesdeMenu() {

        System.out.print("👤 Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("👤 Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("📅 Fecha de Nacimiento (yyyy-MM-dd): ");
        String fechaNacimientoStr = scanner.nextLine();
        LocalDate fechaNacimiento;

        try {
            fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            System.out.println("❌ Error: Fecha inválida.");
            return;
        }

        if (fechaNacimiento.isAfter(LocalDate.now())) {
            System.out.println("❌ Error: La fecha de nacimiento no puede estar en el futuro.");
            return;
        }


        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
        String dui = "00000000-0"; // Valor por defecto

        if (edad >= 18) {
            System.out.print("🆔 Ingrese el DUI (xxxxxxxxx) sin guiones: ");
            dui = scanner.nextLine();
            if (!dui.matches("\\d{8}-\\d{1}")) {
                System.out.println("El dui no es válido");
                return;
            }
        }


        Paciente nuevoPaciente = new Paciente(nombre, apellido, dui, fechaNacimiento);
        managerPaciente.agregarPaciente(nuevoPaciente);
    }


    public void agregarDoctordesMenu() {

        System.out.print("👤 Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("👤 Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("📅 Fecha de Nacimiento (yyyy-MM-dd): ");
        String fechaNacimientoStr = scanner.nextLine();
        LocalDate fechaNacimiento;

        try {
            fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            System.out.println("❌ Error: Fecha inválida.");
            return;
        }

        if (fechaNacimiento.isAfter(LocalDate.now())) {
            System.out.println("❌ Error: La fecha de nacimiento no puede estar en el futuro.");
            return;
        }

        System.out.print("🆔 Ingrese el DUI: ");
        String dui = scanner.nextLine();
        if (!dui.matches("\\d{8}-\\d{1}")) {
            System.out.println("El dui no es válido");
            return;
        }

        System.out.println("Especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.println("Fecha de reclutacion (yyyy-MM-dd): ");
        String fechaReclutacionStr = scanner.nextLine();

        LocalDate fechaReclutacion;

        try {
            fechaReclutacion = LocalDate.parse(fechaReclutacionStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            System.out.println("❌ Error: Fecha inválida.");
            return;
        }


        Doctor nuevoDoctor = new Doctor(nombre, apellido, dui, fechaNacimiento, fechaReclutacion, especialidad);

        managerDoctor.agregarDoctor(nuevoDoctor);
    }

    public void agregarCitasMenu() {

        System.out.println("Escriba el id del paciente: ");
        String idPaciente = scanner.nextLine();

        System.out.println("Escriba el codigo del doctor: ");
        String codigoDoctor = scanner.nextLine();


        System.out.print("📅 Fecha de Cita (yyyy-MM-dd): ");
        String fechaCitaStr = scanner.nextLine();
        LocalDate fechaCita;
        LocalTime horaCita;
        String horaCitaStr;

        try {
            fechaCita = LocalDate.parse(fechaCitaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            System.out.println("❌ Error: Fecha inválida.");
            return;
        }


        if (fechaCita.isAfter(LocalDate.now())) {
            horaCita = getRandomTimeBetween(8, 16);
        } else {
            System.out.println("Hora de cita: ");
            horaCitaStr = scanner.nextLine();
            horaCita = LocalTime.parse(horaCitaStr, DateTimeFormatter.ofPattern("HH:mm"));
        }


        System.out.println("Hora de cita: ");


        manager.agendarCita(idPaciente, codigoDoctor, fechaCita, horaCita);

    }

    private LocalTime getRandomTimeBetween(int startHour, int endHour) {
        Random random = new Random();
        int hour = startHour + random.nextInt(endHour - startHour);
        int minute = 0;
        return LocalTime.of(hour, minute);
    }


    public void EliminarCita() {
        System.out.println("Ingrese el codigo de cita: ");
        String codigoCita = scanner.nextLine();

        manager.DeleteCita(codigoCita);

    }

    private void findCitasPorDoctorMenu() {

        System.out.println("Ingrese el codigo del doctor: ");
        String codigoDoctor = scanner.nextLine();

        manager.findCitaDoctor(codigoDoctor);
    }

    private void findCitasPorFecha(){

        System.out.println("Ingrese la fecha de cita: ");
        String fechaCitaStr = scanner.nextLine();

        LocalDate fechaCita = LocalDate.parse(fechaCitaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        manager.findCitaFecha(fechaCita);

    }

    private void marcarAsistenciaMenu() {
        System.out.println("Ingrese el codigo de cita: ");
        String codigoCita = scanner.nextLine();

        manager.marcarAsistencia(codigoCita);
    }

    public static void printBox(String text) {
        int length = text.length();
        String horizontalBorder = "+" + "-".repeat(length + 2) + "+";

        System.out.println(horizontalBorder);
        System.out.println("| " + text + " |");
        System.out.println(horizontalBorder);
    }








}
