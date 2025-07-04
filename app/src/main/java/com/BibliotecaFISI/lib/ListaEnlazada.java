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
    if (pos <= 1 || CAB == null) {
        nodo.sgte = CAB;
        if (CAB != null) {
            CAB.prev = nodo;
        }
        CAB = nodo;
        return;
    }

    Nodo<T> ptr = CAB;
    int i = 1;

    while (ptr.sgte != null && i < pos - 1) {
        ptr = ptr.sgte;
        i++;
    }

    nodo.sgte = ptr.sgte;
    if (ptr.sgte != null) {
        ptr.sgte.prev = nodo;
    }

    ptr.sgte = nodo;
    nodo.prev = ptr;
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
        if (CAB == null || nodo == null) return;

        if (CAB == nodo) {
            CAB = nodo.sgte;
            if (CAB != null) {
                CAB.prev = null;
            }
            return;
        }

        if (nodo.prev != null) {
            nodo.prev.sgte = nodo.sgte;
        }

        if (nodo.sgte != null) {
            nodo.sgte.prev = nodo.prev;
        }
    }
}

