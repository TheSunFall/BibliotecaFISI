/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BibliotecaFISI.lib;

public class Usuario {
    // Atributos
    private String nombre;
    private String correo;
    private char tipo;
    private String contrasena;
    private int codigoEstudiante;
    private int dni;
    private Ejemplar[] carritoCompras;
    private Prestamo[] prestamos;

    // Constructor
    public Usuario(String nombre, String correo, char tipo, String contrasena, 
                 int codigoEstudiante, int dni) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
        this.contrasena = contrasena;
        this.codigoEstudiante = codigoEstudiante;
        this.dni = dni;
        this.carritoCompras = new Ejemplar[10]; // Tamaño inicial arbitrario
        this.prestamos = new Prestamo[5]; // Tamaño inicial arbitrario
    }

    // Métodos
    public Prestamo[] verPrestamo() {
        return this.prestamos;
    }

    public void registrarDatos(String nombre, String correo, char tipo, 
                            String contrasena, int codigoEstudiante, int dni) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
        this.contrasena = contrasena;
        this.codigoEstudiante = codigoEstudiante;
        this.dni = dni;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Ejemplar[] getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(Ejemplar[] carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public Prestamo[] getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamo[] prestamos) {
        this.prestamos = prestamos;
    }
}

