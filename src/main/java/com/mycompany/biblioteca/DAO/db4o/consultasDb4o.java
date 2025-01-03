/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.db4o;

import com.db4o.ObjectSet;
import static com.mycompany.biblioteca.DAO.db4o.conexionDb4o.db;
import com.mycompany.biblioteca.models.Usuario;

/**
 *
 * @author edma2
 */
public class consultasDb4o {
    private void añadirUsuario(Usuario usuario){
        db.store(usuario);
    }
    
    private ObjectSet<Usuario>listarUsuarios(){
        return db.query(Usuario.class);
    }
    
    private void deleteUsuario(Usuario usuario){
        db.delete(usuario);
    }
    
}
