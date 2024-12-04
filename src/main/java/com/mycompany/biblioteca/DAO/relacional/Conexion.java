/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.relacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JHB
 */
public class Conexion {
    protected Connection conexion;
    String url = "jdbc:mysql://localhost:3306/ad_biblioteca";
    String usuario = "Admin";
    String pwd="1234";
    
    public Connection conectar(){
        try{
            conexion = (Connection) DriverManager.getConnection(url,usuario,pwd);
            System.out.println("CONEXION ESTABLECIDA");
        }catch(SQLException e){
            System.err.println("ERROR AL CONECTAR");
        }
        return conexion;
    }
}
