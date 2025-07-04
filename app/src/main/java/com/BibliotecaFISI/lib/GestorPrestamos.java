package com.BibliotecaFISI.lib;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class GestorPrestamos {

    public void guardarPrestamosEnArchivo(String nombreArchivo, List<Prestamo> prestamos) {
        try {
            URL url = getClass().getResource("/prestamos.txt");

            File archivo;
            if (url != null) {
                archivo = new File(url.toURI());
            } else {
                archivo = new File("src/main/resources/prestamos.txt");
                archivo.createNewFile();
            }

            // Escribir en el archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write("ID#ISBN#CodigoEstudiante#FechaInicio#FechaFin#Devuelto");
                writer.newLine();

                for (Prestamo p : prestamos) {
                    writer.write(p.getId() + "#" +
                            p.getEjemplar().ISBN + "#" +
                            p.getUsuario().getCodigoEstudiante() + "#" +
                            p.getFechaInicio() + "#" +
                            p.getFechaFin() + "#" +
                            p.isDevuelto());
                    writer.newLine();
                }

                System.out.println("Préstamos guardados correctamente en " + archivo.getPath());
            }
        } catch (Exception e) {
            System.err.println("Error al guardar préstamos: " + e.getMessage());
        }
    }

    public List<Prestamo> leerPrestamosDesdeArchivo(
            String nombreArchivo,
            List<Usuario> usuarios,
            List<Ejemplar> ejemplares
    ) {
        List<Prestamo> prestamos = new ArrayList<>();

        try (InputStream input = getClass().getResourceAsStream("/prestamos.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            String linea;
            boolean esPrimera = true;

            while ((linea = reader.readLine()) != null) {
                if (esPrimera) {
                    esPrimera = false;
                    continue;
                }

                String[] partes = linea.split("#");
                if (partes.length < 6) continue;

                int id = Integer.parseInt(partes[0]);
                int isbn = Integer.parseInt(partes[1]);
                int codigoEstudiante = Integer.parseInt(partes[2]);
                LocalDate inicio = LocalDate.parse(partes[3]);
                LocalDate fin = LocalDate.parse(partes[4]);
                boolean devuelto = Boolean.parseBoolean(partes[5]);

                Ejemplar ejem = buscarEjemplarPorISBN(ejemplares, isbn);
                Usuario usuario = buscarUsuarioPorCodigo(usuarios, codigoEstudiante);

                if (ejem != null && usuario != null) {
                    Prestamo p = new Prestamo(ejem, usuario, inicio, fin);
                    p.setId(id);
                    p.setDevuelto(devuelto);
                    prestamos.add(p);
                }
            }

            System.out.println("Préstamos cargados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al leer préstamos: " + e.getMessage());
        }

        return prestamos;
    }

    // Busca ejemplar por ISBN
    public Ejemplar buscarEjemplarPorISBN(List<Ejemplar> lista, int isbn) {
        for (Ejemplar e : lista) {
            if (e.ISBN == isbn) return e;
        }
        return null;
    }

    // Busca usuario por código
    public Usuario buscarUsuarioPorCodigo(List<Usuario> lista, int codigo) {
        for (Usuario u : lista) {
            if (u.getCodigoEstudiante() == codigo) return u;
        }
        return null;
    }

    // Sobrecarga del método para cuando no tienes las listas
    public List<Prestamo> leerPrestamosDesdeArchivo(String nombreArchivo) {
        return new ArrayList<>(); // Retorna lista vacía si no hay usuarios/ejemplares
    }
}