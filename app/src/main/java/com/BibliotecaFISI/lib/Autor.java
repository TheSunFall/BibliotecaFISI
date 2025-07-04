/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BibliotecaFISI.lib;

/**
 *
 * @author Juan Aguilar
 */
public class Autor {
    public String nombre;
    public String fechaNac;
    public String descripcion;
    public ListaEnlazada<Ejemplar> ejemplares;

    public Autor(String nombre, String fechaNac, String descripcion) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.descripcion = descripcion;
    }
    
    public void AsignarEjemplar(Ejemplar ej) {
        this.ejemplares.Anexar(new Nodo(ej));
    }
}
