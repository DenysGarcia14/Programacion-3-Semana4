package com.uped.proyecto.modelo;
import java.time.LocalDate;

public class Suscripcion {
    private String usuario;
    private String plan;
    private LocalDate inicio;
    private int meses;

    // Constructor completo: el unico que valida
    public Suscripcion(String usuario, String plan,
                       LocalDate inicio, int meses) {
        if (meses <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad de meses debe ser mayor a cero.");
        }
        this.usuario = usuario;
        this.plan = plan;
        this.inicio = inicio;
        this.meses = meses;
    }
    // Nivel 3: asume 1 mes de duracion
    public Suscripcion(String usuario, String plan, LocalDate inicio) {
        this(usuario, plan, inicio, 1);
    }
    // Nivel 2: asume la fecha de hoy como inicio
    public Suscripcion(String usuario, String plan) {
        this(usuario, plan, LocalDate.now());
    }
    // Nivel 1: asume plan GRATIS
    public Suscripcion(String usuario) {
        this(usuario, "GRATIS");
    }
    @Override
    public String toString() {
        return "Suscripcion{usuario='" + usuario + "', plan='" + plan
                + "', inicio=" + inicio + ", meses=" + meses + "}";
    }
    public static Suscripcion gratuita(String usuario) {
        return new Suscripcion(usuario, "GRATIS");
    }
    public static Suscripcion premium(String usuario) {
        return new Suscripcion(usuario, "PREMIUM");
    }

    // --- Esto es lo NUEVO que agregas para el Ejercicio 3 ---
    private Suscripcion(Builder b) {
        this.usuario = b.usuario;
        this.plan = b.plan;
        this.inicio = b.inicio;
        this.meses = b.meses;
    }

    public static class Builder {
        private String usuario;
        private String plan = "GRATIS";
        private LocalDate inicio = LocalDate.now();
        private int meses = 1;

        public Builder usuario(String u) { this.usuario = u; return this; }
        public Builder plan(String p) { this.plan = p; return this; }
        public Builder inicio(LocalDate i) { this.inicio = i; return this; }
        public Builder meses(int m) {
            if (m <= 0) {
                throw new IllegalArgumentException(
                        "La cantidad de meses debe ser mayor a cero.");
            }
            this.meses = m;
            return this;
        }
        public Suscripcion build() {
            if (usuario == null || usuario.isBlank()) {
                throw new IllegalArgumentException(
                        "El usuario no puede estar vacío.");
            }
            return new Suscripcion(this);
        }
    }
}
