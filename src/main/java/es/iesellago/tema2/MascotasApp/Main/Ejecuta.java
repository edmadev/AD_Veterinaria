/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.iesellago.tema2.MascotasApp.Main;

import es.iesellago.tema2.MascotasApp.Controller.ConexionMySQL;
import es.iesellago.tema2.MascotasApp.Controller.ConsultasDML;
import es.iesellago.tema2.MascotasApp.Controller.ConsultasPaciente;
import es.iesellago.tema2.MascotasApp.View.Menu;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

/**
 * Clase prinicipal donde se realiza la conexión con la base de datos.
 *
 * @author mauri_
 */
public class Ejecuta {

    public static void main(String[] args) {
        ConexionMySQL conexion = new ConexionMySQL();
        conexion.getConnection();
        Menu m = new Menu();
        m.setVisible(true);
    }
}

//se instancia la clase ConexionMySQL y se llama al método getConnection para establecer la conexión con la bd
//        ConsultasDML consulta = new ConsultasDML();
//        ConsultasPaciente consultaPaciente = new ConsultasPaciente();
//System.out.println(consultaPaciente.listaMascotas().toString());
//        LocalDate fecha = LocalDate.of(2010, 10, 23);
//        Date  sqlFecha = Date.valueOf(fecha);
//consulta.insertPaciente("leonidas", "perro", "monoasud", "verde", sqlFecha);
// System.out.println("numero de especie: "+consultaPaciente.recuentoPorEspecie("perro"));
//  System.out.println(consultaPaciente.topMasVacunas(2));
//System.out.println(consultaPaciente.topMasPesados(10));
//prueba inserccion csv
//        String url = "C:\\iesellago3\\AD\\prueba.csv";
//        consulta.insertUsuarioPorArchivo(url);
//LocalDate fecha = LocalDate.of(2010, 10, 23);
//Date  sqlFecha = Date.valueOf(fecha);
//consulta.insertPaciente("chivo", "caniche", "perro", "negro", sqlFecha);
//        LocalDate fechaV = LocalDate.of(2024, 10, 1);
//        LocalDate fechaVProx = LocalDate.of(2024, 11, 1);
//        Date fechaVacuna = Date.valueOf(fechaV);
//        Date fechaVacunaProxima = Date.valueOf(fechaVProx);
//consulta.insertarVacunas(1, fechaVacuna, "Ebola", fechaVacunaProxima);
//consulta.insertarVacunas(1, fechaVacuna, "Sida", fechaVacunaProxima);
//consulta.updatePaciente("Carechimba", "perro", "chiwawa", "rosa", fechaVacuna, 1);
//consulta.insertPaciente("tobi", "siames", "gato", "gris", fechaVacuna);
//insertar peso
//        LocalDate fechaLocalP = LocalDate.of(2021, 4, 2);
//        Date fechaDateP = Date.valueOf(fechaLocalP);
//        consulta.insetarPesos(1, fechaDateP, 22.4);
//        
//        LocalDate fechaLocalP2 = LocalDate.of(2021, 4, 2);
//        Date fechaDateP2= Date.valueOf(fechaLocalP);
//        consulta.insetarPesos(2, fechaDateP2, 102.4);
//        
//        //actualizar vacuna
//        LocalDate fechaActV = LocalDate.of(2019, 12, 12);
//        Date fechaDateACtV = Date.valueOf(fechaActV);
//        
//        LocalDate fechaActVProx = LocalDate.of(2025, 9, 12);
//        Date fechaDateACtVProx = Date.valueOf(fechaActVProx);
//        
//        consulta.updateVacuna(6, fechaDateACtV, "sarampion", fechaDateACtVProx);
//            //actualizar peso
//            LocalDate fechaActP = LocalDate.of(2001, 12, 12);
//            Date fechaDateActP = Date.valueOf(fechaActP);
//            consulta.updatePeso(1, fechaDateActP, 199.99);
// LocalDate fechaPacienteEliminar = LocalDate.of(2001, 1, 1);
//Date fechaPacienteDateEliminar = Date.valueOf(fechaPacienteEliminar);
//consulta.insertPaciente("Eliminar", "Eliminar", "Eliminar", "Eliminar", fechaPacienteDateEliminar);
//consulta.insertarVacunas(4, fechaPacienteDateEliminar, " Eliminar", fechaPacienteDateEliminar);
//consulta.insetarPesos(4, fechaPacienteDateEliminar, 12.21);
//PRUEBA DE ELIMINACIONES

          //  consulta.deletePaciente(4);
