package com.uped.proyecto.modelo;

public class Vehiculo {
    private final String placa;
    private String marca;
    private int kilometraje;

    // Constructor completo
    public Vehiculo(String placa, String marca, int kilometraje) {
        validar(placa, kilometraje);
        this.placa = placa;
        this.marca = marca;
        this.kilometraje = kilometraje;
    }

    // Constructor abreviado, encadenado con this(...)
    public Vehiculo(String placa, String marca) {
        this(placa, marca, 0);
    }

    // Validación extraída a método privado
    private void validar(String placa, int kilometraje) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException(
                    "La placa no puede estar vacía.");
        }
        if (kilometraje < 0) {
            throw new IllegalArgumentException(
                    "El kilometraje no puede ser negativo: " + kilometraje);
        }
    }

    // Método de fábrica estático que usa el constructor abreviado
    public static Vehiculo nuevo(String placa, String marca) {
        return new Vehiculo(placa, marca);
    }

    // Incrementa el kilometraje solo si km > 0
    public void recorrer(int km) {
        if (km > 0) {
            this.kilometraje += km;
        } else {
            System.out.println("Los kilómetros a recorrer deben ser mayores a 0.");
        }
    }

    @Override
    public String toString() {
        return "Vehiculo{placa='" + placa + "', marca='" + marca
                + "', kilometraje=" + kilometraje + "}";
    }
}

