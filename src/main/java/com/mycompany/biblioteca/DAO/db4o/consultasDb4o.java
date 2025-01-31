/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.db4o;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import static com.mycompany.biblioteca.DAO.db4o.conexionDb4o.db;
import com.mycompany.biblioteca.models.Usuario;

/**
 *
 * @author edma2
 */
public class consultasDb4o {
    private ObjectContainer objectContainer;
    
    
    private boolean añadirUsuario(Usuario usuario){
        System.out.println("INSERTAR USUARIO: " + usuario.getNombre());
        try{
            if(usuario.getNombre()!=null){
                db.store(usuario);
                return true;
            }else if (usuario.getNombre()==null){
                System.out.println("NOMBRE DE USUARIO NULO");
                return false;
            }
        }catch (Exception e) {
            System.err.println("Error al insertar accion DAO: " + e.getMessage());
        
        }
        return false;
    }
    
    private ObjectSet<Usuario>listarUsuarios(){
        return db.query(Usuario.class);
    }
    private boolean actualizarUsuario(Usuario usuarioOriginal,String nombre, String email, String tipo, int telefono){
        ObjectSet<Usuario> resultado = db.queryByExample(usuarioOriginal);
        try{
            if(resultado.hasNext()){
                Usuario nuevoUsuario = resultado.next();
                nuevoUsuario.setNombre(nombre);
                nuevoUsuario.setEmail(email);
                nuevoUsuario.setTipo(tipo);
                nuevoUsuario.setTelefono(telefono);
                db.store(nuevoUsuario);
                System.out.println("USUARIO ACTUALIZADO CORRECTAMENTE");
                return true;
            }
        }catch (Exception e) {
            System.err.println("Error al intentar actualizar la accion" + e.getMessage());
            }
        return false;
    }
    
    private boolean deleteUsuario(Usuario usuario){
        System.out.println("ELIMINAR USUARIO: " + usuario.getNombre());
        try{
            ObjectSet<Usuario> resultado = db.queryByExample(usuario);
            if(resultado.hasNext()){
                db.delete(usuario);
                System.out.println("SE HA ELIMINADO CORRECTAMENTE EL USUARIO " + usuario.getNombre());
                return true;
            }else{
                System.out.println("NO SE ENCONTRÓ AL USUARIO");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al intentar eliminar accion DAO: " + e.getMessage());
            return false;
        }
    }
    
}
