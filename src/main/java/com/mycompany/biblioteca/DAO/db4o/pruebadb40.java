/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.db4o;

import com.db4o.*;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.mycompany.biblioteca.models.Usuario;

/**
 *
 * @author dam
 */
public class pruebadb40 {

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "prueba");

        Usuario usuario = new Usuario("Pablo", "da", "todo", 0);
        Usuario usuario2 = new Usuario("Marta", "dadad", "nina", 12);
        db.store(usuario);
        db.store(usuario2);

        ObjectSet<Usuario> resultado = db.query(Usuario.class);
        while (resultado.hasNext()) {
            Usuario u = resultado.next();
            System.out.println(u);
        }

        db.close();

    }
}
