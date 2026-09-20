package com.uped.proyecto;

import com.uped.proyecto.modelo.Pedido;
import com.uped.proyecto.modelo.Suscripcion;
import com.uped.proyecto.modelo.ConfiguracionReporte;
import com.uped.proyecto.modelo.Carrito;
import com.uped.proyecto.modelo.Empleado;
import com.uped.proyecto.modelo.Punto;
import com.uped.proyecto.modelo.Vehiculo;
import com.uped.proyecto.modelo.LibroBiblioteca;
import com.uped.proyecto.modelo.Registro;

public class Main {
    public static void main(String[] args) {

        // ===== Pedido =====
        Pedido pedido = new Pedido(101);
        System.out.println("Pedido numero: " + pedido.getNumero());
        System.out.println();

        // ===== Suscripcion (constructores encadenados) =====
        Suscripcion s1 = new Suscripcion("ana");
        System.out.println(s1);

        Suscripcion s2 = Suscripcion.premium("carlos");
        System.out.println(s2);

        // ===== Suscripcion (Builder - Ejercicio 3) =====
        Suscripcion s3 = new Suscripcion.Builder()
                .usuario("elena")
                .plan("PREMIUM")
                .build();
        System.out.println(s3);
        System.out.println();

        // ===== ConfiguracionReporte (Builder) =====
        ConfiguracionReporte config = new ConfiguracionReporte.Builder()
                .titulo("Ventas Q3")
                .conGrafico()
                .build();
        System.out.println(config);
        System.out.println();

        // ===== Carrito =====
        Carrito carrito = new Carrito();
        carrito.agregar("Café");
        carrito.agregar("Azúcar");
        carrito.getItems().clear(); // solo modifica la copia
        System.out.println("Items en el carrito: " + carrito.getItems().size());
        System.out.println();

        // ===== Empleado =====
        Empleado empleado = new Empleado("04512378-9", "Analista");
        System.out.println(empleado);
        empleado.ascender("Analista Senior");
        System.out.println(empleado);
        System.out.println();

        // ===== Punto =====
        Punto original = new Punto(2, 3);
        Punto movido = original.mover(1, 1);
        System.out.println("Original: " + original);
        System.out.println("Movido: " + movido);
        System.out.println();

        // ===== Vehiculo =====
        Vehiculo vehiculo = new Vehiculo("N123-456", "Toyota");
        System.out.println(vehiculo);

        Vehiculo v1 = Vehiculo.nuevo("P123-789", "Kia");
        System.out.println(v1);
        v1.recorrer(150);
        System.out.println(v1);
        v1.recorrer(-20); // no debe sumar, imprime mensaje de aviso

        // Caso invalido: se captura para no detener el programa
        try {
            Vehiculo invalido = new Vehiculo("", "Hyundai", 5000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado (Vehiculo): " + e.getMessage());
        }
        System.out.println();

        // ===== LibroBiblioteca =====
        var l1 = new LibroBiblioteca("Clean Code", "R. Martin", 3);
        var l2 = LibroBiblioteca.unico("Effective Java", "J. Bloch");
        l1.prestar();
        l2.prestar();
        l2.prestar(); // sin ejemplares disponibles, imprime aviso

        // Caso invalido: se captura para no detener el programa
        // try {
         //   new LibroBiblioteca("", "Autor X", 2);
       // } catch (IllegalArgumentException e)  {
          //  System.out.println("Error esperado (LibroBiblioteca): " + e.getMessage());
        //}
       // System.out.println();

        // ===== Registro =====
        new Registro();
    }
}