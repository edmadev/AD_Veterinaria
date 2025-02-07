/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.noRelacional;

/**
 *
 * @author edma2
 */
public class PruebaMain {

    public static void main(String[] args) {
        ConexionMongoDB conexion = new ConexionMongoDB();
        conexion.conectarMongoDB();
        ConsultasMongoDB consulta = new ConsultasMongoDB();
//        consulta.insertarUsuario("edwin", "hola@gmail.com", "empleado", 456456);
//        consulta.obtenerUsuario("Esaddwin");
//        consulta.borrarUsuario("edwin");
//        consulta.actualizarUsuario("edwin", "adios", "tutor", 666666);
        conexion.cerrarConexionMongoDB();
    }
}
