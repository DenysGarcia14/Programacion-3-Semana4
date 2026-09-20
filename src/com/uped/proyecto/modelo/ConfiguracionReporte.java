package com.uped.proyecto.modelo;

public class ConfiguracionReporte {
    private final String titulo;
    private final boolean incluirGrafico;
    private final String formato;
    private ConfiguracionReporte(Builder b) {
        this.titulo = b.titulo;
        this.incluirGrafico = b.incluirGrafico;
        this.formato = b.formato;
    }
    public static class Builder {
        private String titulo = "Reporte";
        private boolean incluirGrafico = false;
        private String formato = "PDF";
        public Builder titulo(String t) {
            this.titulo = t;
            return this;
        }
        public Builder conGrafico() {
            this.incluirGrafico = true;
            return this;
        }
        public ConfiguracionReporte build() {
            return new ConfiguracionReporte(this);
        }
    }
    @Override
    public String toString() {
        return "ConfiguracionReporte{titulo='" + titulo
                + "', incluirGrafico=" + incluirGrafico
                + ", formato='" + formato + "'}";
    }
}
