package com.uped.proyecto.modelo;

public class Punto {
    private final double x;
    private final double y;
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punto mover(double dx, double dy) {
        return new Punto(x + dx, y + dy);
    }
    @Override
    public String toString() {
        return "Punto(" + x + ", " + y + ")";
    }
}
