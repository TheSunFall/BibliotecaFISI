package com.BibliotecaFISI.lib;

public class ListaEnlazada<T> {
    public Nodo<T> CAB;
    ListaEnlazada() {
        CAB = null;
    }
    public void Anexar (Nodo<T> nodo) {
        if (CAB == null) {
            CAB = nodo;
        }
        Nodo<T> ptr = CAB;
        while (ptr.sgte != null) {
            ptr = ptr.sgte;
        }
        ptr.sgte = nodo;
        nodo.prev = ptr;
    }
    public void Insertar(Nodo<T> nodo, int pos) {
        Nodo<T> ptr = CAB;
        int i = 1;
        while (ptr != null && i <= pos) {
            ptr = ptr.sgte;
            i++;
        }
        if (ptr == null) {
            CAB = nodo;
        }
        else {
            ptr.sgte = nodo;
            nodo.prev = ptr;
        }
    }
    public int Buscar(Nodo<T> nodo) {
        Nodo<T> ptr = CAB;
        int i = 1;
        while (ptr != null) {
            if (ptr == nodo) {
                return i;
            }
            ptr = ptr.sgte;
            i++;
        }
        return -1;
    }
    public Nodo<T> Buscar(int pos) {
        Nodo<T> ptr = CAB;
        int i = 1;
        while (ptr != null && i <= pos) {
            ptr = ptr.sgte;
            i++;
        }
        return ptr;
    }
    public void Eliminar(Nodo<T> nodo) {
        if (CAB == null) {
            return;
        }
        if (CAB == nodo) {
            CAB = null;
            return;
        }
        Nodo<T> ptr = CAB;
        while (ptr != null) {
            if (ptr == nodo) {
                ptr.prev.sgte = ptr.sgte;
                return;
            } else {
                ptr = ptr.sgte;
            }
        }

    }
}
