package com.BibliotecaFISI.lib;

import javax.swing.table.DefaultTableModel;
import java.io.*;

public class ArbolBinario {
    private Nodo<Ejemplar> R;

    public ArbolBinario() {
        R = null;
    }

    public void Insertar(Ejemplar e) {
        // se usa anterior como izquierda y siguiente como derecha
        if (R == null) {
            R = new Nodo<>(e);
        } else {
            Nodo<Ejemplar> ptr = R;
            while (ptr.sgte != null && ptr.prev != null) {
                if (e.ISBN < ptr.val.ISBN) {
                    ptr = ptr.prev;
                } else if (e.ISBN > ptr.val.ISBN) {
                    ptr = ptr.sgte;
                } else {
                    System.out.println("el isbn ya existe");
                    return;
                }
            }
            if (e.ISBN < ptr.val.ISBN) {
                ptr.prev = new Nodo<>(e);
            } else if (e.ISBN > ptr.val.ISBN) {
                ptr.sgte = new Nodo<>(e);
            }

        }
    }

    public Nodo<Ejemplar> BuscarPorISBN(Nodo<Ejemplar> ptr, int isbn) {
        if (ptr == null) {
            return null;
        }
        if (ptr.val.ISBN == isbn) {
            return R;
        } else if (isbn < ptr.val.ISBN) {
            return BuscarPorISBN(ptr.prev, isbn);
        } else {
            return BuscarPorISBN(ptr.sgte, isbn);
        }
    }

    public void buscarPorTitulo(Nodo<Ejemplar> ptr, String titulo, DefaultTableModel model) {
        ListaEnlazada<Ejemplar> l = new ListaEnlazada<>();
        if (ptr != null) {
            if (ptr.val.titulo.toLowerCase().contains(titulo.toLowerCase())) {
                model.addRow(new Object[]{ptr.val.ISBN, ptr.val.titulo});
            }
            buscarPorTitulo(ptr.prev, titulo, model);
            buscarPorTitulo(ptr.sgte, titulo, model);
        }
    }

    public void recorrerInorden() {
        recorrerInordenRec(R);
    }

    private void recorrerInordenRec(Nodo<Ejemplar> ptr) {
        if (ptr != null) {
            recorrerInordenRec(ptr.prev);
            System.out.println(ptr.val);
            recorrerInordenRec(ptr.sgte);
        }
    }

    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            guardarEnArchivoRec(R, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    private void guardarEnArchivoRec(Nodo<Ejemplar> raiz, BufferedWriter writer) throws IOException {
        if (raiz != null) {
            writer.write(raiz.val.ISBN + "#" + raiz.val.titulo);
            writer.newLine();
            guardarEnArchivoRec(raiz.prev, writer);
            guardarEnArchivoRec(raiz.sgte, writer);
        }
    }

    public void leerDesdeArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("#");
                int ISBN = Integer.parseInt(partes[0]);
                String titulo = partes[1];
                Insertar(new Ejemplar(ISBN, titulo));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Nodo<Ejemplar> getR() {
        return R;
    }
}
