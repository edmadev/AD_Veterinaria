/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es auxiliar a
 * {@link com.mycompany.ad_veterinarioapp.Controller.ConsultasDML} , donde se
 * realiza la lectura un archivo CSV con sus correspondientes métodos.
 *
 * @author mauri_
 */
public class ConversorCSV {

    /**
     * Este método realiza la conversión de un archivo .CSV saltando la cabecera
     * de este y quedándose con los datos, haciendo split de ';'.
     *
     * @param ruta Ruta del archivo que se va a leer.
     * @param numeroFilas El numero de filas que tiene el archivo que tendrá
     * que recorrerse con el BufferedReader, está soportado por {@link #obtenerNumeroFilas(java.lang.String)
     * }
     * @return Un array bidimensional de String que contiene todos los datos que
     * se desea añadir.
     */
    public String[][] conversorCSV(String ruta, int numeroFilas) {
        String[][] tabla = new String[obtenerNumeroFilas(ruta)][6];
        String[][] datos = new String[obtenerNumeroFilas(ruta) - 1][6];
        File archivo = new File(ruta);
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                for (int j = 0; j < partes.length && j < tabla[i].length; j++) {
                    tabla[i][j] = partes[j];

                }
                i++;
            }
            for (i = 1; i < tabla.length; i++) {
                for (int j = 0; j < tabla[i].length; j++) {
                    if (i - 1 < datos.length) {
                        datos[i - 1][j] = tabla[i][j];
                    }

                }

            }

            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConversorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConversorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datos;

    }

    /**
     * Método auxiliar a {@link #ConversorCSV()} donde se lee el archivo CSV al
     * completo, obteniendo unicamente el número de filas que se nesita en el
     * método mencionado anteriormente.
     *
     * @param ruta Ruta del archivo a leer.
     * @return El número de filas del archivo.
     */
    public int obtenerNumeroFilas(String ruta) {
        File archivo = new File(ruta);
        FileReader fr = null;
        BufferedReader br = null;
        int numeroFilas = 0;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while (br.readLine() != null) {
                numeroFilas++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConversorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConversorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numeroFilas;
    }

}
