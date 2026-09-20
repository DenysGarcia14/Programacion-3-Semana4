package com.uped.proyecto.modelo;
import java.time.LocalDate;
public class Empleado {
    private final String dui;
    private final LocalDate fechaIngreso;
    private String cargo;
    public Empleado(String dui, String cargo) {
        this.dui = dui;
        this.fechaIngreso = LocalDate.now();
        this.cargo = cargo;
    }
    public void ascender(String nuevoCargo) {
        this.cargo = nuevoCargo;
    }
    @Override
    public String toString() {
        return "Empleado{dui='" + dui + "', cargo='" + cargo + "'}";
    }

}
