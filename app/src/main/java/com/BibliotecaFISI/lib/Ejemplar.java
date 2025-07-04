package com.BibliotecaFISI.lib;

public class Ejemplar {
    public long ISBN;
    public String fechapub;
    public String titulo;
    public String autor;
    public int cantidad;
    public String palabrasClave;
    public String descripcion;
    
    public Ejemplar(long ISBN, String titulo) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor="Autor desconocido";
        this.palabrasClave="Sin palabras clave";
        this.descripcion="Contenido no disponible";
    }

    public Ejemplar(long ISBN, String titulo, String autor, String palabrasClave, String descripcion) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.palabrasClave = palabrasClave;
        this.descripcion = descripcion;
    }
    
    public Ejemplar(long ISBN, String titulo, String palabrasClave) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor="Autor desconocido";
        this.palabrasClave = palabrasClave;
        this.descripcion="Contenido no disponible";
    }
    
    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Título: " + titulo + ", Autor: " + autor;
    }
}
