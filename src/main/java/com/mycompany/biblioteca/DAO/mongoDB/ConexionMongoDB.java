/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.mongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author dam
 */
public class ConexionMongoDB {

    private static final String URI = "mongodb://localhost:27017";
    private static final String nombreDB = "ad_biblioteca";
    public static MongoClient mongoClient;

    public static MongoClient conectarMongoDB() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(URI);
            try {
                MongoDatabase database = mongoClient.getDatabase(nombreDB);
                System.out.println("Conectado a la base de datos de mongoDB: " + database.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mongoClient;
    }

    public static void cerrarConexionMongoDB() {
        if(mongoClient!=null){
            mongoClient.close();
            System.out.println("Se ha cerrado la conexion con mongoDB");
        }
    }

}
