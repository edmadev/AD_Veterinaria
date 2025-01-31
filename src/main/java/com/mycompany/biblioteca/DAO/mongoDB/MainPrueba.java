/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.mongoDB;

/**
 *
 * @author dam
 */
public class MainPrueba {
    public static void main(String[] args) {
        ConexionMongoDB conn = new ConexionMongoDB();
        conn.conectarMongoDB();
        conn.cerrarConexionMongoDB();
    }
   
}
