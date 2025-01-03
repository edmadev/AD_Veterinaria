/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesellago.tema2.MascotasApp.Controller;

import es.iesellago.tema2.MascotasApp.Model.Paciente;
import es.iesellago.tema2.MascotasApp.Model.Peso;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Clase que tiene distintos métodos de ordenación y obtención de datos.
 * @author mauri_
 */
public class ConsultasPaciente {

    private Connection conexion;

    public ConsultasPaciente() {
        this.conexion = new ConexionMySQL().getConnection();
    }
    
    /**
     * Se hace una lista de todos los pacientes y sus datos. Se irán añadiendo a un ArrayList que se imprimirá posteriormente.
     * @return El ArrayList que contiene todos los datos de los pacientes.
     */
    public ArrayList<Paciente> listaMascotas() {
        ArrayList<Paciente> listaMascotas = new ArrayList<Paciente>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idMascota, aliasMascota, especie, raza, colorPelo, fechaNacimiento, vacunaciones FROM paciente";
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            //mientras pueda continuar, irá creando los pacientes
            while (rs.next()) {
                int idMascota = rs.getInt("idMascota");
                String aliasMascota = rs.getString("aliasMascota");
                String especie = rs.getString("especie");
                String raza = rs.getString("raza");
                String colorPelo = rs.getString("colorPelo");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                int vacunaciones = rs.getInt("vacunaciones");
                Paciente paciente = new Paciente(idMascota, aliasMascota, especie, raza, colorPelo, fechaNacimiento, vacunaciones);
                listaMascotas.add(paciente);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar las mascotas: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
        }
        return listaMascotas;

        //ok
    }

    /**
     * Método que hace el top de las mascotas con más vacunas ordenados de mayor a menor.
     * @param limiteRegistros Se establece el límite de animales que se va a mostrar.
     * @return Los datos de los pacientes según el criterio del top.
     */
    public ArrayList<Paciente> topMasVacunas(int limiteRegistros) {
        ArrayList<Paciente> topMasVacunas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idMascota, aliasMascota, vacunaciones FROM paciente ORDER BY vacunaciones DESC LIMIT ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, limiteRegistros);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idMascota = rs.getInt("idMascota");
                String aliasMascota = rs.getString("aliasMascota");
                int vacunaciones = rs.getInt("vacunaciones");
                Paciente paciente = new Paciente(idMascota, aliasMascota, vacunaciones);
                topMasVacunas.add(paciente);
            }

        } catch (SQLException ex) {
            System.err.println("Error al listar el top de vacunas: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }

        }
        return topMasVacunas;
        //ok

    }

    
    /**
     * Método que hace el top de las mascotas con más pesadas ordenados de mayor a menor.
     * @param limiteRegistros Se establece el límite de animales que se va a mostrar.
     * @return Los datos de los pacientes según el criterio del top.
     */
    public ArrayList<Peso> topMasPesados(int limiteRegistros) {
        ArrayList<Peso> topMasPesados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT p.idMascota, p.aliasMascota, pe.idPeso, pe.peso FROM paciente p INNER JOIN peso pe ON p.idMascota = pe.idMascota ORDER BY pe.peso DESC LIMIT ? ";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, limiteRegistros);
            rs = ps.executeQuery();
            while (rs.next()){
                int idMascota=rs.getInt("p.idMascota");
                String aliasMascota = rs.getString("p.aliasMascota");
                int idPeso = rs.getInt("pe.idPeso");
                double peso = rs.getDouble("pe.peso");
                Peso pesoObjeto = new Peso(idMascota, idPeso, peso);
                topMasPesados.add(pesoObjeto);
                
                
            }

        } catch (SQLException ex) {
            System.err.println("Error al listar el top de vacunas: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }

        }
        return topMasPesados;
        //OK 
    }
    
    /**
     * Metodo que ordena los pesos de las mascotas de menor a mayor, siendo los primeros en mostrarse los más ligeros.
     * @param limiteRegistros Limite de elementos que se van a mostrar eleigido por el usuario.
     * @return ArrayList con la lista de los animales ordenados según el criterio.
     */
     public ArrayList<Peso> topMasLigeros(int limiteRegistros) {
        ArrayList<Peso> topMasLigeros = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT p.idMascota, p.aliasMascota, pe.idPeso, pe.peso FROM paciente p INNER JOIN peso pe ON p.idMascota = pe.idMascota ORDER BY pe.peso ASC LIMIT ? ";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, limiteRegistros);
            rs = ps.executeQuery();
            while (rs.next()){
                int idMascota=rs.getInt("p.idMascota");
                String aliasMascota = rs.getString("p.aliasMascota");
                int idPeso = rs.getInt("pe.idPeso");
                double peso = rs.getDouble("pe.peso");
                Peso pesoObjeto = new Peso(idMascota, idPeso, peso);
                topMasLigeros.add(pesoObjeto);
                
                
            }

        } catch (SQLException ex) {
            System.err.println("Error al listar el top de vacunas: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }

        }
        return topMasLigeros;
        //OK 
    }


    
    /**
     * Realiza el conteo del numero de especies según el criterio introducido por el usuario.
     * @param especie La especie animal que se desea hacer el conteo.
     * @return El número de veces que se repite la especie animal introducida por parámetro.
     */
    public int recuentoPorEspecie(String especie) {
        int recuento = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(*) AS Recuento_de_" + especie + " FROM paciente WHERE especie LIKE ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, especie);
            rs = ps.executeQuery();

            if (rs.next()) {
                recuento = rs.getInt("Recuento_de_" + especie);
            }

        } catch (SQLException ex) {
            System.err.println("Error realizar el conteo : " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
        }
        return recuento;
        //ok
    }

}
