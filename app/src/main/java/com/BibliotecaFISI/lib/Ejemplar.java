package com.BibliotecaFISI.lib;

public class Ejemplar {
    public int ISBN;
    public String titulo;
    public Ejemplar(int ISBN, String titulo) {
        this.ISBN = ISBN;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", titulo: " + titulo;
    }
}
