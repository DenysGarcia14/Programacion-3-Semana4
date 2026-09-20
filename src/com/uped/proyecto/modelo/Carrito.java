package com.uped.proyecto.modelo;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<String> items = new ArrayList<>();
    public void agregar(String producto) {
        items.add(producto);
    }
    public List<String> getItems() {
        return new ArrayList<>(items); // copia defensiva
    }
}
