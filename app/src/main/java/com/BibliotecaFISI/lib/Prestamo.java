package com.BibliotecaFISI.lib;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private static int contador = 100000;
    private int id;
    private Ejemplar ejemplar;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean devuelto;

    // Constructor
    public Prestamo(Ejemplar ejemplar, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = ++contador;
        this.ejemplar = ejemplar;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.devuelto = false;
    }

    public int getId() {
        return id;
    }

    // Cargar el ID desde archivo
    public void setId(int id) {
        this.id = id;
        if (id > contador) {
            contador = id;
        }
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    // Verifica si el préstamo está en plazo (no vencido o ya devuelto)
    public boolean estaEnPlazo() {
        LocalDate hoy = LocalDate.now();
        return devuelto || !fechaFin.isBefore(hoy);
    }

    // Calcula los días de retraso si no ha sido devuelto y está vencido
    public int mostrarDiasRetraso() {
        if (!estaEnPlazo()) {
            LocalDate hoy = LocalDate.now();
            return (int) ChronoUnit.DAYS.between(fechaFin, hoy);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nEjemplar: " + ejemplar +
                "\nUsuario: " + usuario.getNombre() +
                "\nDesde: " + fechaInicio +
                " hasta " + fechaFin +
                (devuelto ? "\nEstado: Devuelto" : "\nEstado: Pendiente");
    }
}

