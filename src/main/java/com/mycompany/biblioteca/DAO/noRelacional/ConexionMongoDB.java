/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.noRelacional;

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
    public static MongoClient mongoClient; //patrón singletone para instanciar unicamente un mongoClient 

    public static MongoClient conectarMongoDB() {
        if (mongoClient == null) { //patron singletone: verifica si ya existe una instancia
            mongoClient = MongoClients.create(URI); //patrón singletone : si no existe (es null), la crea
            try {
                MongoDatabase database = mongoClient.getDatabase(nombreDB);
                System.out.println("Conectado a la base de datos de mongoDB: " + database.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mongoClient; //patrón singletone : devuelve la misma instancia de mongoClient
    }

    public static void cerrarConexionMongoDB() {
        if(mongoClient!=null){
            mongoClient.close(); //patrón singletone : cierra la conexion
            mongoClient=null; // patrón singletone : permite volver a clearla en el futuro ya que vuelve a ser null
            System.out.println("Se ha cerrado la conexion con mongoDB");
        }
    }

}
