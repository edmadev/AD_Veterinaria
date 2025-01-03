/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

/**
 *
 * @author edma2
 */
public class conexionDb4o {
    private static final String DB = "biblioteca";
    public static  ObjectContainer db;
    
    public static ObjectContainer abrirConexionDb40(){
        if(db == null){
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB);
        }
        return db;
    }
    
    public static void cerrarConexionDb4o(){
        if(db!=null){
            db.close();
        }
    }
    
}
