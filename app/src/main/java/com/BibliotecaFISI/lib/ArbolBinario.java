package com.BibliotecaFISI.lib;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
    private Nodo<Ejemplar> R;

    public ArbolBinario() {
        R = null;
    }

    public void Insertar(Ejemplar e) {
        if (R == null) {
            R = new Nodo<>(e);
        } else {
            Nodo<Ejemplar> ptr = R;
            while (true) {
                if (e.ISBN < ptr.val.ISBN) {
                    if (ptr.prev == null) {
                        ptr.prev = new Nodo<>(e);
                        return;
                    }
                    ptr = ptr.prev;
                } else if (e.ISBN > ptr.val.ISBN) {
                    if (ptr.sgte == null) {
                        ptr.sgte = new Nodo<>(e);
                        return;
                    }
                    ptr = ptr.sgte;
                } else {
                    System.out.println("El ISBN ya existe");
                    return;
                }
            }
        }
    }

    public Nodo<Ejemplar> BuscarPorISBN(Nodo<Ejemplar> ptr, long isbn) {
        if (ptr == null) {
            return null;
        }
        if (ptr.val.ISBN == isbn) {
            return ptr;
        } else if (isbn < ptr.val.ISBN) {
            return BuscarPorISBN(ptr.prev, isbn);
        } else {
            return BuscarPorISBN(ptr.sgte, isbn);
        }
    }

    public List<Ejemplar> buscarPorTitulo(String titulo) {
        List<Ejemplar> res = new ArrayList<>();
        buscarPorTituloRec(R, res, titulo);
        return res;
    }

    private void buscarPorTituloRec(Nodo<Ejemplar> ptr, List<Ejemplar> ejemplares, String titulo) {
        if (ptr != null) {
            // Recorremos primero el subárbol izquierdo
            buscarPorTituloRec(ptr.prev, ejemplares, titulo);

            if (ptr.val.titulo.toLowerCase().contains(titulo.toLowerCase())) {
                ejemplares.add(ptr.val);
            }

            // Recorremos luego el subárbol derecho
            buscarPorTituloRec(ptr.sgte, ejemplares, titulo);
        }
    }

    
    public List<Ejemplar> buscarPorKeywords(String kw) {
        List<Ejemplar> res = new ArrayList<>();
        buscarPorKeywordsRec(R, res, kw);
        return res;
    }

    private void buscarPorKeywordsRec(Nodo<Ejemplar> ptr, List<Ejemplar> ejemplares, String kw) {
        if (ptr != null) {
            // Recorremos primero el subárbol izquierdo
            buscarPorKeywordsRec(ptr.prev, ejemplares, kw);

            if (ptr.val.palabrasClave.toLowerCase().contains(kw.toLowerCase())) {
                ejemplares.add(ptr.val);
            }

            // Recorremos luego el subárbol derecho
            buscarPorKeywordsRec(ptr.sgte, ejemplares, kw);
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
