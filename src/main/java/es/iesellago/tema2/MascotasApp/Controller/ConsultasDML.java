/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesellago.tema2.MascotasApp.Controller;

import es.iesellago.tema2.MascotasApp.Model.Paciente;
import es.iesellago.tema2.MascotasApp.Tools.ConversorCSV;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Se realizará las insercciones, actualizaciones y eliminaciones de datos de
 * las tablas "vacuna", "pesos" y "paciente".
 * @author mauri_
 *
 */
public class ConsultasDML {

    /**
     * Se instancia conexion para establecerla
     */
    private Connection conexion;

    /**
     * Obtenemos la conexion a la base de datos al inicializarse la clase
     */
    public ConsultasDML() {
        this.conexion = new ConexionMySQL().getConnection();
    }

    /**
     * Método de inserccion de datos al paciente, no se pide ni el idMascota ni
     * el numero de vacunas ya que se asignará automaticamente e inicialmente en
     * 0, respectivamente.
     *
     * @param aliasMascota nombre de la mascota
     * @param especie
     * @param raza
     * @param colorPelo
     * @param fechaNacimiento
     * @return El numero de filas afectadas
     */
    public int insertPaciente(String aliasMascota, String especie, String raza, String colorPelo, java.sql.Date fechaNacimiento) {
        PreparedStatement ps = null;
        int filasAfectadas = -1;
        Paciente paciente = new Paciente();
        try {
            String consulta = "INSERT INTO paciente(aliasMascota,especie,raza,colorPelo,fechaNacimiento,vacunaciones) VALUES (?,?,?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, aliasMascota);
            ps.setString(2, especie);
            ps.setString(3, raza);
            ps.setString(4, colorPelo);
            ps.setDate(5, fechaNacimiento);
            ps.setInt(6, paciente.getVacunaciones());
            filasAfectadas = ps.executeUpdate();
            System.out.println("Numero de inserciones: " + filasAfectadas);
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexion cerrada con exito");
                } catch (Exception e) {
                    System.err.println("Error al cerrar PreparedStatement: " + e.toString());
                }
            }
        }

        return filasAfectadas;
    }

    /**
     * Metodo de inserccion de datos del peso.
     *
     * @param idMascota
     * @param fecha
     * @param peso
     * @return
     */
    public int insetarPesos(int idMascota, java.sql.Date fecha, double peso) {
        PreparedStatement ps = null;
        int filasAfectadas = -1;

        try {
            String consulta = "INSERT INTO peso (idMascota,fecha,peso) VALUES (?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idMascota);
            ps.setDate(2, fecha);
            ps.setDouble(3, peso);
            filasAfectadas = ps.executeUpdate();
            System.out.println("Filas insertadas: " + filasAfectadas);

        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexion cerrada con exito");
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.toString());
                }
            }
        }
        return filasAfectadas;

        //ok
    }

    /**
     * Metodo de inserccion de vacunas, está soportado por dos métodos
     * auxiliares: {@link #obtenerNumeroVacunaciones(int)} y {@link #actulizarVacunacionesAnadidas(int, int)
     * }.
     *
     * @param idMascota
     * @param fecha Fecha de cuándo se le puso la vacuna
     * @param enfermedad
     * @param fechaProxima Fecha de la siguiente vacuna
     * @return
     */
    public int insertarVacunas(int idMascota, java.sql.Date fecha, String enfermedad, java.sql.Date fechaProxima) {
        PreparedStatement ps = null;

        int filasAfectadas = -1;
        try {
            String consulta = "INSERT INTO vacuna (idMascota, fecha, enfermedad, fechaProxima) VALUES (?,?,?,?)";
            ps = conexion.prepareStatement(consulta);

            ps.setInt(1, idMascota);
            ps.setDate(2, fecha);
            ps.setString(3, enfermedad);
            ps.setDate(4, fechaProxima);

            int numVacunaciones = obtenerNumeroVacunaciones(idMascota);
            actulizarVacunacionesAnadidas(idMascota, numVacunaciones);

            filasAfectadas = ps.executeUpdate();
            System.out.println("Se ha añadido vacuna");

        } catch (SQLException ex) {
            System.err.println("Error al insertar filas: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Se ha cerrado PreparedSatement correctamente");
                } catch (Exception e) {
                    System.err.println("No se ha cerrado correctamente PreparedStatement: " + e.toString());
                }
            }
        }

        return filasAfectadas;

        //ok
    }

    //metodo para obtener unicamente el numero de vacunaciones del paciente
    /**
     * Método auxiliar a
     * {@link #insertarVacunas(int, java.sql.Date, java.lang.String, java.sql.Date)}.
     * Se hace un SELECT de las vacunaciones de un paciente en concreto.
     *
     * @param idMascota Parámetro que identifica el paciente del que queremos
     * obtener su número de vacunas.
     * @return El número de vacunaciones que tiene el paciente de idMascota.
     */
    public int obtenerNumeroVacunaciones(int idMascota) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int numeroVacunaciones = 0;
        try {
            String consulta = "SELECT vacunaciones FROM paciente WHERE idMascota = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idMascota);
            rs = ps.executeQuery();

            //Comprobamos que rs tenga parametros de comprobacion.
            if (rs.next()) {
                //obtenemos el valor de la columna deseada, en este caso "vacunaciones".
                numeroVacunaciones = rs.getInt("vacunaciones");

            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido obtener el numero de vacunaciones: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra ResultSet: " + e.getMessage());
                }
            }
        }
        return numeroVacunaciones;
        //ok

    }

    /**
     * Método auxiliar a {@link #insertarVacunas(int, java.sql.Date, java.lang.String, java.sql.Date)
     * }. Su función es actualizar el número de vacunaciones, suma {@link #obtenerNumeroVacunaciones(int)
     * } +1 , ya que siempre se añade las vacunas de 1 en 1.
     *
     * @param idMascota
     * @param getVacunaciones
     * @return
     */
    public int actulizarVacunacionesAnadidas(int idMascota, int getVacunaciones) {
        PreparedStatement ps = null;
        int filasAfectadasa = -1;
        int actualizarVacunas = getVacunaciones + 1;
        try {
            String consulta = "UPDATE paciente SET vacunaciones = ? WHERE idMascota = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, actualizarVacunas);
            ps.setInt(2, idMascota);
            filasAfectadasa = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al intentar actualizar");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("No se ha podido cerrar PreparedStatement: " + ex.getMessage());
                }
            }
        }
        return filasAfectadasa;

        //ok
    }

    /**
     * Actualiza datos del paciente según su id.
     *
     * @param aliasMascota
     * @param especie
     * @param raza
     * @param colorPelo
     * @param fechaNacimiento
     * @param idMascota
     * @return True o False si se ha actualizado exitosamente.
     */
    public boolean updatePaciente(String aliasMascota, String especie, String raza, String colorPelo, java.sql.Date fechaNacimiento, int idMascota) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        int filasActualizadas;
        try {
            String consulta = "UPDATE paciente SET aliasMascota = ?, especie = ?, raza = ?, colorPelo = ?, fechaNacimiento = ? WHERE idMascota = ? ";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, aliasMascota);
            ps.setString(2, especie);
            ps.setString(3, raza);
            ps.setString(4, colorPelo);
            ps.setDate(5, fechaNacimiento);
            ps.setInt(6, idMascota);
            filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se ha encontrado el paciente con id: " + idMascota);
            }

        } catch (SQLException ex) {
            System.err.println("No se ha podido actualizar: " + ex.toString());
        } finally {
            if (ps != null) {

                try {
                    ps.close();
                    System.out.println("Se ha cerrado PreparedStatement correctamente");
                } catch (Exception e) {
                    System.err.println("No se ha cerrado correctamente PreparedStatement: " + e.toString());
                }
            }
        }
        return actualizacionExitosa;

        //ok
    }

    /**
     * Actualiza la vacuna segun idVacuna.
     *
     * @param idVacuna
     * @param fecha
     * @param enfermedad
     * @param fechaProxima
     * @return True o False si se actualizado correctamente.
     */
    public boolean updateVacuna(int idVacuna, java.sql.Date fecha, String enfermedad, java.sql.Date fechaProxima) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        int filasActualizadas;
        try {
            String consulta = "UPDATE vacuna SET fecha = ?, enfermedad = ?, fechaProxima = ? WHERE idVacuna = ?";

            ps = conexion.prepareStatement(consulta);

            ps.setDate(1, fecha);
            ps.setString(2, enfermedad);
            ps.setDate(3, fechaProxima);
            ps.setInt(4, idVacuna);
            filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Actualizacion exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se ha encontrado la vacuna con id" + idVacuna);
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar actualizar vacuna: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Se ha cerrado correctamente PreparedStaement");
                } catch (Exception e) {
                    System.out.println("no se ha cerrado correctamente PreparedStatement: " + e.toString());
                }
            }
        }
        return actualizacionExitosa;
        //ok
    }

    /**
     * Actualiza el peso segun su id.
     *
     * @param idPeso
     * @param fecha
     * @param peso
     * @return True o False si se actualizado correctamente.
     */
    public boolean updatePeso(int idPeso, java.sql.Date fecha, double peso) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        int filasActualizadas;
        try {
            String consulta = "UPDATE peso SET fecha = ? , peso = ? WHERE idPeso =?";
            ps = conexion.prepareStatement(consulta);
            ps.setDate(1, fecha);
            ps.setDouble(2, peso);
            ps.setInt(3, idPeso);
            filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se ha encontrado el peso con id: " + idPeso);
            }

        } catch (SQLException ex) {
            System.out.println("Error al intentar actualizar vacuna: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Se ha cerrado correctamente PreparedStatement");
                } catch (Exception e) {
                    System.err.println("No se ha cerrado correctamente PreparedStatement: " + e.toString());
                }
            }
        }
        return actualizacionExitosa;

        //ok
    }

    /**
     * Borra el paciente al completo, está soportado por el método {@link #deleteVacunaYPeso(int)
     * }.
     *
     * @param idMascota
     * @return El numero de filas afectadas.
     */
    public int deletePaciente(int idMascota) {
        deleteVacunaYPeso(idMascota);
        PreparedStatement ps = null;
        int filasAfectatadas = -1;
        try {
            String consulta = "DELETE FROM paciente WHERE idMascota = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idMascota);
            filasAfectatadas = ps.executeUpdate();
            System.out.println("Numero de insercciones: " + filasAfectatadas);

        } catch (SQLException ex) {
            System.err.println("Error al modificar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con exito.");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return filasAfectatadas;
    }

    /**
     * Complementa a {@link #deletePaciente(int) }. Se trata de dos consultas
     * donde hace DELETE de la tabla vacuna y la tabla peso según la clave
     * foránea que tienen asignadas.
     *
     * @param idMascota Es la clave foránea con la cual se consigue borrar las
     * tablas peso y vacuna.
     * @return El numero de filas afectadas.
     */
    public int deleteVacunaYPeso(int idMascota) {
        PreparedStatement psVacuna = null;
        PreparedStatement psPeso = null;
        int filasModificadas = 0;
        int filasModificadas2 = 0;
        try {
            String consulta = "DELETE FROM vacuna WHERE idMascota = ?";
            String consulta2 = "DELETE FROM peso WHERE idMascota =?";
            psVacuna = conexion.prepareStatement(consulta);
            psPeso = conexion.prepareStatement(consulta2);
            psVacuna.setInt(1, idMascota);
            psPeso.setInt(1, idMascota);
            filasModificadas = psVacuna.executeUpdate();
            filasModificadas2 = psPeso.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error al intentar borrar la mascota: " + ex.getMessage());
        } finally {
            if (psVacuna != null) {
                try {
                    psVacuna.close();
                } catch (Exception e) {
                    System.err.println("No se ha cerrado correctamente PreparedStatement vacuna: " + e.getMessage());
                }
            }
            if (psPeso != null) {
                try {
                    psPeso.close();
                } catch (Exception e) {
                    System.err.println("No se ha cerrado correctamente PreparedStatement peso: " + e.getMessage());
                }
            }
        }
        return filasModificadas + filasModificadas2;
        //ok
    }

    /**
     * Borra el registro UNICAMENTE de la tabla vacuna según idVacuna.
     *
     * @param idVacuna Parametro con el que se borra la tabla.
     * @return El numero de filas afectadas.
     */
    public int deleteVacuna(int idVacuna) {
        PreparedStatement ps = null;
        int filasAfectatadas = -1;
        try {
            String consulta = "DELETE FROM vacuna WHERE idVacuna = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idVacuna);
            filasAfectatadas = ps.executeUpdate();
            System.out.println("Numero de insercciones: " + filasAfectatadas);
        } catch (SQLException ex) {
            System.err.println("Error al modificar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con exito.");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return filasAfectatadas;
        //OK
    }

    /**
     * Borra el registro UNICAMENTE de la tabla vacuna según idVacuna.
     *
     * @param idPeso Parametro con el que se borra la tabla.
     * @return El numero de filas afectadas.
     */
    public int deletePeso(int idPeso) {
        PreparedStatement ps = null;
        int filasAfectatadas = -1;
        try {
            String consulta = "DELETE FROM peso WHERE idPeso = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idPeso);
            filasAfectatadas = ps.executeUpdate();
            System.out.println("Numero de insercciones: " + filasAfectatadas);
        } catch (SQLException ex) {
            System.err.println("Error al modificar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con exito.");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return filasAfectatadas;
    }
    //ok

    /**
     * Insercción del usuario mediante un archivo CSV. La estructura CSV debe
     * contener estas columnas: aliasMascota | especie | raza | colorPelo |
     * fechaNacimiento | vacunaciones
     * 
     *  Este método está soportado por los métodos del paquete Tools.
     * @param ruta La URL del archivo que contiene todos los datos.
     * @return El número de insercciones que se han realizado.
     */
    public int insertUsuarioPorArchivo(String ruta) {
        ConversorCSV conversor = new ConversorCSV();
        int numeroFilas = conversor.obtenerNumeroFilas(ruta);
        String[][] tabla = conversor.conversorCSV(ruta, numeroFilas);
        PreparedStatement ps = null;
        
        int filasInsertadas = 0;
        try {
            String consulta = "INSERT INTO paciente (aliasMascota,especie,raza,colorPelo,fechaNacimiento,vacunaciones)  VALUES (?,?,?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            
            //se recorre la tabla.
            for (String[] fila : tabla) {
                ps.setString(1, fila[0]);
                ps.setString(2, fila[1]);
                ps.setString(3, fila[2]);
                ps.setString(4, fila[3]);

                try {
                    LocalDate lD = LocalDate.parse(fila[4]);
                    Date fechaNacimiento = Date.valueOf(lD);
                    ps.setDate(5, fechaNacimiento);
                } catch (Exception e) {
                }

                ps.setInt(6, Integer.parseInt(fila[5]));

                filasInsertadas += ps.executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return filasInsertadas;
    }

}

/*
base de datos:

DROP DATABASE IF EXISTS veterinaria;
CREATE DATABASE veterinaria;
use veterinaria;
CREATE TABLE paciente(
   idMascota int AUTO_INCREMENT PRIMARY KEY   ,
    aliasMascota varchar (100) ,
	especie varchar (100) ,
    raza varchar (100) ,
    colorPelo varchar (100) ,
    fechaNacimiento date ,
    vacunaciones int
    );
    
CREATE TABLE peso(
    idPeso int AUTO_INCREMENT PRIMARY KEY ,
    idMascota int,
    fecha date,
    peso double,
    FOREIGN KEY (idMascota) REFERENCES paciente(idMascota)
);

CREATE TABLE vacuna(
    idVacuna int AUTO_INCREMENT PRIMARY KEY,
    idMascota int,
    fecha date,
    enfermedad varchar (100),
    fechaProxima date,
    FOREIGN KEY (idMascota) REFERENCES paciente(idMascota)
);
*/
   