/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesellago.tema2.MascotasApp.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * Esta clase establece y finaliza la conexion con la base de datos
 * Proporciona metodos para obtener y cerrar la conexion
 * @author mauri_
 * 
 */


//Anteriormente se han añadido las dependencias en el POM del 



public class ConexionMySQL {
    /**
     * Se instancia el objeto Connection para realizar las conexiones
     */
    protected Connection conexion;
    String url = "jdbc:mysql://localhost:3306/veterinaria"; //URL de la base de datos
    String usuario = "Admin"; //Nombre de usuario
    String pwd="1234"; //Contraseña de usuario
    
    
    /**
     * Establecer conexion
     * 
     * @return El resultado de la conexion, tanto establecida como fallida
     */
    public Connection getConnection(){
        try {
            conexion = (Connection) DriverManager.getConnection(url,usuario,pwd);
            System.out.println("Conexion establecida");
        } catch (SQLException ex) {
            System.err.println("Error al intentar establecer conexion: "+ex.toString());
        }
        
        return conexion;
    }
    
    
    
    /**
     * Cierra la conexion.
     * 
     * @return Imprime un string por consola informando del estado de la conexion
     */
    public Connection cerrarConexion(){
        try {
            this.conexion.close();
            System.out.println("Se ha cerrado la conexion");
        } catch (SQLException ex) {
            System.err.println("No  se ha podido cerrar la conexion: "+ex.toString());
        }
        return conexion;
    }
            
}
