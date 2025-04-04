package com.labo1.citas.Presentacion;

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
    String dui = "0000"; // Valor por defecto

    if (edad >= 18) {
        System.out.print("🆔 Ingrese el DUI: ");
        dui = scanner.nextLine();
    }

    Paciente nuevoPaciente = new Paciente(nombre, apellido, dui, fechaNacimiento);
    manager.agregarPaciente(nuevoPaciente);
}
}
