/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BibliotecaFISI.lib;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AdminVerificadorInicio {
    public Usuario Verificador(String correo, char[] password) {
        String line;
        boolean isFirstLine = true; // Variable para verificar la primera línea
        try (InputStream input = getClass().getResourceAsStream("/usuarios.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            
            while ((line = br.readLine()) != null) {
                // Ignorar la primera línea (encabezados)
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] datos = line.split(",");
                // Eliminar espacios en blanco de los datos
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = datos[i].trim();
                }
                
                if (datos.length >= 6) {
                    try {
                        if(datos[3].equals(correo) && datos[1].equals(new String(password)) && datos[4].equals("A")){
                            return new Usuario(
                                datos[2], // nombre
                                datos[3], // correo
                                datos[4].charAt(0), // tipo
                                datos[1], // contraseña
                                Integer.parseInt(datos[0]), // codigoEstudiante (asumiendo que es el primer dato)
                                Integer.parseInt(datos[5]) // dni
                            );
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir el código o DNI: " + e.getMessage());
                    }
                } else {
                    System.err.println("Línea no válida en el archivo: " + line);
                }
            }
        } catch (Exception e) {
            // Agregar impresión de stack trace para depuración
            
        }
        return null; // Si no se encuentra el usuario
    }
}