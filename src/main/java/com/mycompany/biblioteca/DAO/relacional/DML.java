/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.relacional;

import com.mycompany.biblioteca.models.Evento;
import com.mycompany.biblioteca.models.Libro;
import com.mycompany.biblioteca.models.Prestamo;
import com.mycompany.biblioteca.models.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JHB
 */
public class DML {

    private Connection conexion;

    public DML() {
        this.conexion = new Conexion().conectar();
    }

    public int registrarLibro(String titulo, String autor, String genero, int año) {
        PreparedStatement ps = null;
        int filas = 0;
        Libro libro = new Libro(titulo, autor, genero, año);
        try {
            String consulta = "INSERT INTO libros(titulo_libro,autor,genero,año_publicacion) VALUES (?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setString(3, genero);
            ps.setInt(4, año);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }

    public boolean actualizarLibro(String titulo, String autor, String genero, int año) {
        PreparedStatement ps = null;
        boolean actualizado = false;
        int filas = 0;
        try {
            String consulta = "UPDATE libros SET titulo_libro = ?,autor = ?,genero = ?, año_publicacion =? WHERE"
                    + " titulo_libro = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setString(3, genero);
            ps.setInt(4, año);
            filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("ACTUALIZACION EXITOSA");
                actualizado = true;
            } else {
                System.out.println("NO SE HA ENCONTRADO EL LIBRO LLAMADO " + titulo);
            }
        } catch (SQLException ex) {
            System.err.println("NO SE PUDO ACTUALIZAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("NO SE PUDO CORTAR LA CONEXION: " + e.toString());
                }
            }
        }
        return actualizado;
    }

    public int eliminarLibro(String titulo) {
        PreparedStatement ps = null;
        int filas = 0;
        try {
            String consulta = "DELETE FROM libros WHERE titulo_libro = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, titulo);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE ELIMINACIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL ELIMINAR: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.getMessage());
                }
            }
        }
        return filas;
    }

    public int registrarUsuario(String nombre, String email, String tipo, int telefono) {
        PreparedStatement ps = null;
        int filas = 0;
        Usuario usuario = new Usuario(nombre, email, tipo, telefono);
        try {
            String consulta = "INSERT INTO usuarios(nombre_usuario,email,tipo_usuario,telefono) VALUES (?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, tipo);
            ps.setInt(4, telefono);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }

    public boolean actualizarUsuario(String nombre, String email, String tipo, int telefono) {
        PreparedStatement ps = null;
        boolean actualizado = false;
        int filas = 0;
        try {
            String consulta = "UPDATE usuarios SET nombre_usuario = ?,email = ?,tipo_usuario = ?, telefono =? WHERE"
                    + " nombre_usuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, tipo);
            ps.setInt(4, telefono);
            filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("ACTUALIZACION EXITOSA");
                actualizado = true;
            } else {
                System.out.println("NO SE HA ENCONTRADO AL USUARIO " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println("NO SE PUDO ACTUALIZAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("NO SE PUDO CORTAR LA CONEXION: " + e.toString());
                }
            }
        }
        return actualizado;
    }

    public int eliminarUsuario(String nombre) {
        PreparedStatement ps = null;
        int filas = 0;
        try {
            String consulta = "DELETE FROM usuarios WHERE nombre_usuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE ELIMINACIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL ELIMINAR: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.getMessage());
                }
            }
        }
        return filas;
    }

    public int registrarEvento(String nombre, Date fecha, String descripcion) {
        PreparedStatement ps = null;
        int filas = 0;
        Evento evento = new Evento(nombre, fecha, descripcion);
        try {
            String consulta = "INSERT INTO eventos(evento,fecha_evento,descipcion) VALUES (?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setDate(2, fecha);
            ps.setString(3, descripcion);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }

    public boolean actualizarEvento(String nombre, Date fecha, String descripcion) {
        PreparedStatement ps = null;
        boolean actualizado = false;
        int filas = 0;
        try {
            String consulta = "UPDATE eventos SET evento = ?,fecha_evento = ?,descripcion = ? WHERE"
                    + " nombre = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setDate(2, fecha);
            ps.setString(3, descripcion);
            filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("ACTUALIZACION EXITOSA");
                actualizado = true;
            } else {
                System.out.println("NO SE HA ENCONTRADO EL EVENTO " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println("NO SE PUDO ACTUALIZAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("NO SE PUDO CORTAR LA CONEXION: " + e.toString());
                }
            }
        }
        return actualizado;
    }

    public int eliminarEvento(String nombre) {
        PreparedStatement ps = null;
        int filas = 0;
        try {
            String consulta = "DELETE FROM eventos WHERE evento = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE ELIMINACIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL ELIMINAR: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.getMessage());
                }
            }
        }
        return filas;
    }

    public int registrarPrestamo(Prestamo prestamo) {
        PreparedStatement ps = null;
        int filas = 0;
        try {
            String consulta = "INSERT INTO prestamos (id_usuario,id_libro,fecha_prestamo,fecha_limite_devolucion) VALUES (?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, prestamo.getIdLibro());
            ps.setInt(2, prestamo.getIdUsuario());
            ps.setDate(3, prestamo.getFechaPrestamo());
            ps.setDate(4, prestamo.getFechaLimiteDevolucion());
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }

    public boolean actualizarPrestamo(Prestamo prestamo) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        int filasActualizadas;
        try {
            String consulta = "UPDATE prestamos SET id_usuario = ?, id_libro = ?, fecha_prestamo = ?, fecha_limite_devolución = ? WHERE id_prestamo = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, prestamo.getIdUsuario());
            ps.setInt(2, prestamo.getIdLibro());
            ps.setDate(3, prestamo.getFechaPrestamo());
            ps.setDate(4, prestamo.getFechaLimiteDevolucion());
            filasActualizadas = ps.executeUpdate();
            if(filasActualizadas>0){
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            }else{
                System.out.println("No se ha encontrado el prestamo de id: "+prestamo.getIdPrestamo());
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al intentar actualizar vacuna: "+ex.toString());
        }finally{
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar PS: "+ex.toString());
                }
            }
        }
        return actualizacionExitosa;
    }

    public int registrarMulta(int idPrestamo, double montoMulta) {
        PreparedStatement ps = null;
        int filasInsertadas = 0;
        try {
            String consulta = "INSERT INTO multas (id_prestamo,monto_multa) VALUES";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idPrestamo);
            ps.setDouble(2, montoMulta);
            filasInsertadas = ps.executeUpdate();
            System.out.println("Numero de insercciones: " + filasInsertadas);

        } catch (SQLException ex) {
            System.err.println("Error al registrar multa: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("No se ha cerrar correctamente PS: " + ex.toString());
                }
            }
        }
        return filasInsertadas;
    }

}
