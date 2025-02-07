/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.main;

import com.mycompany.biblioteca.DAO.noRelacional.ConexionMongoDB;
import com.mycompany.biblioteca.DAO.relacional.Conexion;
import com.mycompany.biblioteca.ui.MenuPrincipal;

/**
 *
 * @author dam
 */
public class Ejecuta {
    public static void main(String[] args) {
        //conexion JDBC
        Conexion c = new Conexion();
        c.conectar();
        
        //conexion MongoDB
          ConexionMongoDB conn = new ConexionMongoDB();
        conn.conectarMongoDB();
        conn.cerrarConexionMongoDB();
        
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        
    }
}
