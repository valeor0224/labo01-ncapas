package com.labo1.citas.Presentacion;

import com.labo1.citas.Modelo.Entity.Doctor;
import com.labo1.citas.Modelo.Entity.Paciente;
import com.labo1.citas.servicio.ManejoCitas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
    private ManejoCitas manager; // ✅ Declare instance variable
    private Scanner scanner;

    // ✅ Constructor initializes `PacienteService` and `Scanner`
    public Menu() {
        this.manager = new ManejoCitas();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Agregar Paciente");
        System.out.println("2. Listar Pacientes");
        System.out.println("3. Agregar Doctor");
        System.out.println("4. Listar Doctores");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                agregarPacienteDesdeMenu();
                break;

            case 2:
                manager.listPatients();
                break;

            case 3:
                agregarDoctordesMenu();
                break;

            case 4:
                manager.listDoctors();
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
    String dui = "00000000-0,"; // Valor por defecto

    if (edad >= 18) {
        System.out.print("🆔 Ingrese el DUI: ");
        dui = scanner.nextLine();
        if(!dui.matches("\\d{8}-\\d{1}")) {
            System.out.println("El dui no es válido");
            return;
        }
    }


    Paciente nuevoPaciente = new Paciente(nombre, apellido, dui, fechaNacimiento);
    manager.agregarPaciente(nuevoPaciente);
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
    if(!dui.matches("\\d{8}-\\d{1}")) {
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

    manager.agregarDoctor(nuevoDoctor);
}
}
